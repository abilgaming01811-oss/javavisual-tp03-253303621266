
# Character Manager — TP3 (Java Visual SIH-6406)

## Deskripsi
Project ini dibuat menggunakan bahasa Java untuk mengelola karakter. Program menerapkan class Character, enum CharacterType, dua constructor, getter dan setter, serta fitur level up, mana, dan pemeriksaan status hidup menggunakan isAlive().

## Screenshot Output

![Output Character Manager](screenshots/output.png)

## Struktur Folder

```text
CharacterManager/
├── src/
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               ├── Main.java
│               └── model/
│                   ├── Character.java
│                   └── CharacterType.java
├── screenshots/
│   └── output.png
├── README.md
└── .gitignore
```

## Identitas Mahasiswa
- Nama lengkap: Abil Febrian Panggabean
- NIM: 253303621266
- Google Docs Bagian D: https://docs.google.com/document/d/1wfWgJsuUar71cdxEwOaybO1XTEGKyPr11RCBjcizp9o/edit?usp=sharing


## TP5 — CharacterManager

### Fitur yang Diimplementasikan

1. `addCharacter()` menambahkan karakter jika nama belum terdaftar.
2. `findByName()` mencari karakter berdasarkan nama.
3. `removeCharacter()` menghapus karakter berdasarkan nama.
4. `getTotalCharacters()` menghitung jumlah karakter yang tersimpan.
5. `getAllCharacters()` mengembalikan salinan ArrayList.
6. `getAverageLevel()` menghitung rata-rata level dan mengembalikan 0 jika list kosong.
7. `findByType()` mencari semua karakter berdasarkan tipe.
8. `findStrongest()` mencari karakter dengan nilai attack tertinggi.

### Fitur Baru Bagian C: findStrongest()

Method `findStrongest()` mencari karakter dengan nilai attack paling tinggi dari daftar karakter yang tersimpan. Method ini mengembalikan objek karakter dengan attack tertinggi. Jika daftar kosong, method mengembalikan `null`.

Method ini tidak mengubah daftar karakter dan tidak mengekspos ArrayList internal, sehingga struktur data CharacterManager tetap terjaga.

### Pengujian

Pengujian dilakukan melalui Main.java, meliputi penambahan karakter, penolakan nama duplikat, pencarian dan penghapusan karakter, rata-rata level, pencarian tipe, salinan ArrayList, serta eksperimen reference.

### Screenshot Output
![Hasil pengujian TP5](screenshots/hasil-pengujian-tp5.png)

### Analisis Reference dan Rancangan

Dokumen Google Docs: https://docs.google.com/document/d/1WKXGvrMSgYoM_9AsWkLYff1ITNmU3Cim8fgmN8RURWU/edit?usp=sharing