package org.example.project.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.viewmodel.ProfileViewModel
import androidx.compose.runtime.remember


object LightColors {
    val Background    = Color(0xFFF5F5F5)
    val Surface       = Color(0xFFFFFFFF)
    val SurfaceDim    = Color(0xFFEEEEEE)
    val TextPrimary   = Color(0xFF212121)
    val TextSecondary = Color(0xFF757575)
    val HeaderTop     = Color(0xFF8D8D8D)
    val HeaderBottom  = Color(0xFF5A5A5A)
    val BtnGrey       = Color(0xFF757575)
    val Divider       = Color(0xFFEEEEEE)
    val IconEmail     = Color(0xFF4CAF50)
    val IconPhone     = Color(0xFF2196F3)
    val IconLocation  = Color(0xFFFF5722)
    val IconWebsite   = Color(0xFF9C27B0)
    val IconSkill     = Color(0xFFFF6584)
    val Accent        = Color(0xFF616161)
}

object DarkColors {
    val Background    = Color(0xFF121212)
    val Surface       = Color(0xFF1E1E1E)
    val SurfaceDim    = Color(0xFF2C2C2C)
    val TextPrimary   = Color(0xFFE0E0E0)
    val TextSecondary = Color(0xFF9E9E9E)
    val HeaderTop     = Color(0xFF2C2C2C)
    val HeaderBottom  = Color(0xFF1A1A1A)
    val BtnGrey       = Color(0xFF616161)
    val Divider       = Color(0xFF2C2C2C)
    val IconEmail     = Color(0xFF81C784)
    val IconPhone     = Color(0xFF64B5F6)
    val IconLocation  = Color(0xFFFF8A65)
    val IconWebsite   = Color(0xFFCE93D8)
    val IconSkill     = Color(0xFFFF8FAB)
    val Accent        = Color(0xFF9E9E9E)
}

@Composable
private fun AppColor(isDark: Boolean, light: Color, dark: Color): Color =
    if (isDark) dark else light


@Composable
fun ProfileHeader(
    name: String,
    title: String,
    bio: String,
    isDarkMode: Boolean,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val headerTop    = AppColor(isDarkMode, LightColors.HeaderTop,    DarkColors.HeaderTop)
    val headerBottom = AppColor(isDarkMode, LightColors.HeaderBottom,  DarkColors.HeaderBottom)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(headerTop, headerBottom)
                )
            )
            .padding(bottom = 36.dp)
    ) {
        IconButton(
            onClick = onEditClick,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 12.dp, end = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Edit Profil",
                tint = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.size(20.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 44.dp, start = 24.dp, end = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(110.dp)
                    .border(3.dp, Color.White.copy(alpha = 0.8f), CircleShape)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(102.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.2f))
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Foto Profil",
                        modifier = Modifier.size(58.dp),
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White.copy(alpha = 0.18f))
                    .padding(horizontal = 16.dp, vertical = 5.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 12.sp,
                    color = Color.White.copy(alpha = 0.85f),
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .width(36.dp)
                    .height(1.dp)
                    .background(Color.White.copy(alpha = 0.35f))
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = bio,
                fontSize = 13.sp,
                color = Color.White.copy(alpha = 0.75f),
                textAlign = TextAlign.Center,
                lineHeight = 21.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
fun EditProfileForm(
    editName: String,
    editBio: String,
    isDarkMode: Boolean,
    onNameChange: (String) -> Unit,
    onBioChange: (String) -> Unit,
    onSave: () -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    val surface    = AppColor(isDarkMode, LightColors.Surface,       DarkColors.Surface)
    val textPrim   = AppColor(isDarkMode, LightColors.TextPrimary,   DarkColors.TextPrimary)
    val textSec    = AppColor(isDarkMode, LightColors.TextSecondary, DarkColors.TextSecondary)
    val accent     = AppColor(isDarkMode, LightColors.Accent,        DarkColors.Accent)
    val divider    = AppColor(isDarkMode, LightColors.Divider,       DarkColors.Divider)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // Judul card
            Text(
                text = "EDIT PROFIL",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = accent,
                letterSpacing = 1.5.sp,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            LabeledTextField(
                label = "Nama",
                value = editName,
                onValueChange = onNameChange,
                isDarkMode = isDarkMode
            )

            Spacer(modifier = Modifier.height(12.dp))

            LabeledTextField(
                label = "Bio",
                value = editBio,
                onValueChange = onBioChange,
                isDarkMode = isDarkMode,
                singleLine = false,
                minLines = 3
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TextButton(
                    onClick = onCancel,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.textButtonColors(contentColor = textSec)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Batal", fontSize = 13.sp)
                }

                // Simpan
                Button(
                    onClick = onSave,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = accent)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Save,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Simpan", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@Composable
fun LabeledTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isDarkMode: Boolean,
    singleLine: Boolean = true,
    minLines: Int = 1,
    modifier: Modifier = Modifier
) {
    val textPrim = AppColor(isDarkMode, LightColors.TextPrimary,   DarkColors.TextPrimary)
    val textSec  = AppColor(isDarkMode, LightColors.TextSecondary, DarkColors.TextSecondary)
    val surface  = AppColor(isDarkMode, LightColors.SurfaceDim,    DarkColors.SurfaceDim)
    val accent   = AppColor(isDarkMode, LightColors.Accent,        DarkColors.Accent)

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(label, fontSize = 12.sp, color = textSec)
        },
        singleLine = singleLine,
        minLines = minLines,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor   = accent,
            unfocusedBorderColor = textSec.copy(alpha = 0.3f),
            focusedTextColor     = textPrim,
            unfocusedTextColor   = textPrim,
            cursorColor          = accent,
            focusedLabelColor    = accent,
            unfocusedLabelColor  = textSec
        )
    )
}


@Composable
fun StatItem(
    value: String,
    label: String,
    isDarkMode: Boolean,
    modifier: Modifier = Modifier
) {
    val textPrim = AppColor(isDarkMode, LightColors.TextPrimary,   DarkColors.TextPrimary)
    val textSec  = AppColor(isDarkMode, LightColors.TextSecondary, DarkColors.TextSecondary)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = value, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = textPrim)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = label, fontSize = 11.sp, color = textSec)
    }
}


@Composable
fun InfoItem(
    icon: ImageVector,
    label: String,
    value: String,
    iconTint: Color,
    isDarkMode: Boolean,
    modifier: Modifier = Modifier
) {
    val textPrim = AppColor(isDarkMode, LightColors.TextPrimary,   DarkColors.TextPrimary)
    val textSec  = AppColor(isDarkMode, LightColors.TextSecondary, DarkColors.TextSecondary)
    val divider  = AppColor(isDarkMode, LightColors.Divider,       DarkColors.Divider)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(iconTint.copy(alpha = 0.13f))
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = iconTint,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = label, fontSize = 11.sp, color = textSec,
                fontWeight = FontWeight.Medium, letterSpacing = 0.5.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = value, fontSize = 14.sp, color = textPrim,
                fontWeight = FontWeight.SemiBold)
        }
        Icon(
            imageVector = Icons.Filled.ChevronRight,
            contentDescription = null,
            tint = divider,
            modifier = Modifier.size(16.dp)
        )
    }
    Divider(color = divider, thickness = 0.5.dp,
        modifier = Modifier.padding(start = 54.dp))
}

// ── Composable: ProfileCard ──────────────────────────────────

@Composable
fun ProfileCard(
    title: String,
    isDarkMode: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val surface = AppColor(isDarkMode, LightColors.Surface,  DarkColors.Surface)
    val accent  = AppColor(isDarkMode, LightColors.Accent,   DarkColors.Accent)
    val divider = AppColor(isDarkMode, LightColors.Divider,  DarkColors.Divider)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)) {
            Text(
                text = title.uppercase(),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = accent,
                letterSpacing = 1.5.sp,
                modifier = Modifier.padding(bottom = 8.dp, start = 4.dp)
            )
            content()
        }
    }
}

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = remember { ProfileViewModel() }
) {
    // Collect StateFlow → Compose State
    val uiState by viewModel.uiState.collectAsState()

    val isDark = uiState.isDarkMode

    // Ambil warna sesuai mode
    val bgColor     = AppColor(isDark, LightColors.Background,    DarkColors.Background)
    val surface     = AppColor(isDark, LightColors.Surface,       DarkColors.Surface)
    val textPrim    = AppColor(isDark, LightColors.TextPrimary,   DarkColors.TextPrimary)
    val textSec     = AppColor(isDark, LightColors.TextSecondary, DarkColors.TextSecondary)
    val btnGrey     = AppColor(isDark, LightColors.BtnGrey,       DarkColors.BtnGrey)
    val divider     = AppColor(isDark, LightColors.Divider,       DarkColors.Divider)
    val iconEmail   = AppColor(isDark, LightColors.IconEmail,     DarkColors.IconEmail)
    val iconPhone   = AppColor(isDark, LightColors.IconPhone,     DarkColors.IconPhone)
    val iconLoc     = AppColor(isDark, LightColors.IconLocation,  DarkColors.IconLocation)
    val iconWeb     = AppColor(isDark, LightColors.IconWebsite,   DarkColors.IconWebsite)
    val iconSkill   = AppColor(isDark, LightColors.IconSkill,     DarkColors.IconSkill)
    val accent      = AppColor(isDark, LightColors.Accent,        DarkColors.Accent)

    val skills = listOf(
        Triple(Icons.Filled.Code,           "Mobile Development", "Kotlin, Compose"),
        Triple(Icons.Filled.Storage,        "Data Management",    "MySQL, MongoDB"),
        Triple(Icons.Filled.DesignServices, "Web Development",    "HTML, CSS, JavaScript")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .verticalScroll(rememberScrollState())
    ) {
        ProfileHeader(
            name        = uiState.name,
            title       = uiState.title,
            bio         = uiState.bio,
            isDarkMode  = isDark,
            onEditClick = { viewModel.enterEditMode() }
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .offset(y = (-20).dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem(value = "17",   label = "Proyek",   isDarkMode = isDark)
                Divider(modifier = Modifier.height(36.dp).width(1.dp), color = divider)
                StatItem(value = "4.00", label = "IPK",      isDarkMode = isDark)
                Divider(modifier = Modifier.height(36.dp).width(1.dp), color = divider)
                StatItem(value = "6",    label = "Semester", isDarkMode = isDark)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Button(
                onClick = { viewModel.toggleFollow() },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (uiState.isFollowing) accent else btnGrey
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
            ) {
                Icon(
                    imageVector = if (uiState.isFollowing) Icons.Filled.Check
                    else Icons.Filled.PersonAdd,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (uiState.isFollowing) "Following" else "Follow",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        if (uiState.isEditMode) {
            EditProfileForm(
                editName   = uiState.editName,
                editBio    = uiState.editBio,
                isDarkMode = isDark,
                onNameChange = { viewModel.onEditNameChange(it) },
                onBioChange  = { viewModel.onEditBioChange(it) },
                onSave       = { viewModel.saveProfile() },
                onCancel     = { viewModel.cancelEdit() }
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = if (isDark) Icons.Filled.DarkMode else Icons.Filled.LightMode,
                    contentDescription = null,
                    tint = if (isDark) Color(0xFFFFD54F) else Color(0xFFFF8F00),
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(14.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Dark Mode",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = textPrim
                    )
                    Text(
                        text = if (isDark) "Tema gelap aktif" else "Tema terang aktif",
                        fontSize = 11.sp,
                        color = textSec
                    )
                }
                Switch(
                    checked = uiState.isDarkMode,
                    onCheckedChange = { viewModel.toggleDarkMode() },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor   = Color.White,
                        checkedTrackColor   = accent,
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = divider
                    )
                )
            }
        }

        ProfileCard(title = "Informasi Kontak", isDarkMode = isDark) {
            InfoItem(icon = Icons.Filled.Email,     label = "Email",
                value = uiState.email,   iconTint = iconEmail, isDarkMode = isDark)
            InfoItem(icon = Icons.Filled.Phone,     label = "Telepon",
                value = uiState.phone,   iconTint = iconPhone, isDarkMode = isDark)
            InfoItem(icon = Icons.Filled.LocationOn, label = "Lokasi",
                value = uiState.location, iconTint = iconLoc,  isDarkMode = isDark)
            InfoItem(icon = Icons.Filled.Language,  label = "Website / GitHub",
                value = uiState.website, iconTint = iconWeb,  isDarkMode = isDark)
        }

        ProfileCard(title = "Keahlian", isDarkMode = isDark) {
            skills.forEach { (icon, label, value) ->
                InfoItem(icon = icon, label = label, value = value,
                    iconTint = iconSkill, isDarkMode = isDark)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}