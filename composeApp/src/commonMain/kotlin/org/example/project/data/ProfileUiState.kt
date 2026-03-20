package org.example.project.data

data class ProfileUiState(
    val name: String = "Pradana Figo Ariasya",
    val title: String = "Mahasiswa Teknik Informatika",
    val bio: String =  "Saya adalah mahasiswa yang sedang menempuh pendidikan di Institut Teknologi Sumatera (ITERA) pada program studi Informatika. Sebagai mahasiswa, saya aktif mengikuti kegiatan perkuliahan serta mempelajari berbagai bidang ilmu yang berkaitan dengan teknologi dan pengembangan sistem informasi.",
    val email: String = "pradana.123140063@student.itera.ac.id",
    val phone: String = "+62 853-8312-2030",
    val location: String = "Bandar Lampung, Indonesia",
    val website: String = "github.com/PradanaFigo",

    // State UI tambahan
    val isFollowing: Boolean = false,
    val isDarkMode: Boolean = false,
    val isEditMode: Boolean = false,

    // State sementara saat edit (sebelum di-save)
    val editName: String = "",
    val editBio: String = ""
)