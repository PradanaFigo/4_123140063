# My Profile App —  (MVVM)

Tugas Praktikum Pertemuan 4 — State Management dan MVVM  
**IF25-22017 Pengembangan Aplikasi Mobile**  
Program Studi Teknik Informatika · Institut Teknologi Sumatera

---

## Deskripsi

Pengembangan lanjutan dari Profile App minggu 3. Aplikasi kini menggunakan arsitektur **MVVM** dengan `StateFlow`, fitur **edit profil**, dan **dark mode toggle** yang sepenuhnya reaktif menggunakan Compose Multiplatform.

---

## Screenshot

| Profile View | Edit Profile | Dark Mode |
|---|---|---|
| <img width="879" height="978" alt="image" src="https://github.com/user-attachments/assets/190f74e5-e0e7-4d12-bf2b-8ebeefedb3e1" />
 | <img width="881" height="972" alt="image" src="https://github.com/user-attachments/assets/63bb7008-a442-47df-a59d-6bdbe567573e" />
| <img width="880" height="978" alt="image" src="https://github.com/user-attachments/assets/5fc1ef3f-ffd6-4fa7-a18e-486071ac2dba" />
 |

---

## Fitur Aplikasi

- Header abu-abu elegan dengan foto profil circular dan tombol edit
- Statistik profil: 17 Proyek, IPK 4.00, 6 Semester
- Tombol Follow / Following dengan toggle state
- Edit Profile form untuk mengubah nama dan bio
- Dark Mode Toggle switch untuk beralih tema terang/gelap
- Informasi kontak: Email, Telepon, Lokasi, Website/GitHub
- Daftar keahlian: Mobile Development, Data Management, Web Development

---

## Data Profil

| Field | Value                 |
|---|-----------------------|
| Nama | *Pradana Figo Ariasya* |
| Title | *Mahasiswa Teknik Informatika* |
| Email | *pradana.123140063@student.itera.ac.id* |
| Telepon | *+62 853-8312-2030*                   |
| Lokasi | *Bandar Lamapung, Indonesia*           |

---

## Struktur Folder

```
composeApp/src/commonMain/kotlin/org/example/project/
├── App.kt                        ← entry point, memanggil ProfileScreen()
├── data/
│   └── ProfileUiState.kt         ← data class semua UI state
├── viewmodel/
│   └── ProfileViewModel.kt       ← StateFlow + semua event handler
└── ui/
    └── ProfileScreen.kt          ← semua composable UI
```

---

## Arsitektur MVVM

```
[ ProfileUiState ]       ← data class (Model)
        ↓
[ ProfileViewModel ]     ← MutableStateFlow + event handlers
        ↓  state              ↑  events
[ ProfileScreen ]        ← Composable (View)
```

**Alur data:**
- `ProfileViewModel` menyimpan state dalam `MutableStateFlow<ProfileUiState>`
- `ProfileScreen` mengobservasi dengan `collectAsState()`
- Setiap aksi user (klik, ketik) dikirim ke `ProfileViewModel` sebagai fungsi event

---

## Composable Functions

| Composable | Deskripsi |
|---|---|
| `ProfileHeader` | Header gradient abu-abu, foto circular, nama, title, bio, tombol edit |
| `EditProfileForm` | Form edit stateless, menerima state dan callback dari ViewModel |
| `LabeledTextField` | TextField reusable dan stateless implementasi state hoisting |
| `StatItem` | Kartu angka statistik reusable (Proyek / IPK / Semester) |
| `InfoItem` | Satu baris info: icon warna-warni + label + value |
| `ProfileCard` | Container card dengan judul seksi, mendukung light/dark mode |
| `ProfileScreen` | Halaman utama — mengobservasi ViewModel dan merakit semua composable |

---

## State Hoisting pada LabeledTextField

```
ProfileScreen
    └── EditProfileForm(
            editName     = uiState.editName,       // state turun ↓
            onNameChange = { viewModel.onEditNameChange(it) }  // event naik ↑
        )
            └── LabeledTextField(
                    value         = editName,      // state turun ↓
                    onValueChange = onNameChange   // event naik ↑
                )
```

`LabeledTextField` tidak menyimpan state sendiri — sepenuhnya dikendalikan dari ViewModel melalui parent.

---

## Event Handler di ViewModel

| Fungsi | Aksi |
|---|---|
| `toggleFollow()` | Toggle status follow/following |
| `toggleDarkMode()` | Toggle tema gelap/terang |
| `enterEditMode()` | Buka form edit, salin data saat ini ke field edit |
| `cancelEdit()` | Tutup form edit, buang perubahan |
| `onEditNameChange(text)` | Update field nama sementara saat mengetik |
| `onEditBioChange(text)` | Update field bio sementara saat mengetik |
| `saveProfile()` | Simpan perubahan nama dan bio ke state utama |

---

## Tema Warna

| Elemen | Light Mode | Dark Mode |
|---|---|---|
| Background | `#F5F5F5` | `#121212` |
| Surface (card) | `#FFFFFF` | `#1E1E1E` |
| Header atas | `#8D8D8D` | `#2C2C2C` |
| Header bawah | `#5A5A5A` | `#1A1A1A` |
| Teks utama | `#212121` | `#E0E0E0` |
| Teks sekunder | `#757575` | `#9E9E9E` |

---

## Cara Menjalankan

```bash
# Desktop (JVM)
./gradlew :composeApp:run

# Android — jalankan lewat Android Studio
```

---

## Dependency Tambahan

Di `composeApp/build.gradle.kts` pada blok `commonMain.dependencies`:

```kotlin
implementation(compose.materialIconsExtended)
```

---

## Catatan Teknis

Karena aplikasi dijalankan di **Desktop (JVM)**, ViewModel tidak menggunakan `viewModel()` dari Compose (hanya untuk Android). Sebagai gantinya menggunakan:

```kotlin
fun ProfileScreen(
    viewModel: ProfileViewModel = remember { ProfileViewModel() }
)
```

---

## Penulis

| |                             |
|---|-----------------------------|
| **Nama** | *Pradana Figo Ariasya*      |
| **NIM** | *123140063*                 |
| **Kelas** | IF25-22017                  |
| **Institusi** | Institut Teknologi Sumatera |

---

*Tugas Praktikum 4 · Tahun Akademik Genap 2025/2026*
