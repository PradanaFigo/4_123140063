package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.data.ProfileUiState

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())

    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun toggleFollow() {
        _uiState.update { currentState ->
            currentState.copy(isFollowing = !currentState.isFollowing)
        }
    }

    fun toggleDarkMode() {
        _uiState.update { currentState ->
            currentState.copy(isDarkMode = !currentState.isDarkMode)
        }
    }

    fun enterEditMode() {
        _uiState.update { currentState ->
            currentState.copy(
                isEditMode = true,
                editName = currentState.name,
                editBio  = currentState.bio
            )
        }
    }

    fun cancelEdit() {
        _uiState.update { currentState ->
            currentState.copy(
                isEditMode = false,
                editName   = "",
                editBio    = ""
            )
        }
    }

    fun onEditNameChange(newName: String) {
        _uiState.update { it.copy(editName = newName) }
    }

    fun onEditBioChange(newBio: String) {
        _uiState.update { it.copy(editBio = newBio) }
    }

    fun saveProfile() {
        _uiState.update { currentState ->
            currentState.copy(
                name       = currentState.editName.ifBlank { currentState.name },
                bio        = currentState.editBio.ifBlank  { currentState.bio  },
                isEditMode = false,
                editName   = "",
                editBio    = ""
            )
        }
    }
}