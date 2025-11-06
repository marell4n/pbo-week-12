# PC Builder Tycoon - Core Engine v1.0 #

### Tim : 
- Azzahra Rachmadia Mumtaz (3124600095)
- Akmal Zaida Fari (3124600112)

### Deskripsi Singkat Arsitektur:
Semua komponen (seperti CPU, RAM, SSD) mewarisi dari satu kelas abstrak BaseComponent. Kelas PC menggunakan relasi Composition untuk komponen wajib dan Aggregation untuk komponen opsional. Selain itu, arsitektur ini menerapkan refaktorisasi "Move Method" untuk memindahkan logika pelaporan ke kelas data yang relevan (seperti PC dan Customer).

### Refleksi dari Azzahra Rachmadia M.
1. **Momen “Aha!” Terbesar:** Saat di-"audit" teman saya, jadi saya melihat ternyata seperti ini yang lebih baik dan sadar apa yang harus saya perbaiki untuk proyek saya.
2. **Kelemahan Terbesar Saya/Tim:** Kurang rapi kodenya, di awal saya tidak ada package, jadi kelas componentnya berantakan. Saat melihat kode teman saya yang saya audit, sangat rapi jadi saya tidak memberikan kesalahan apapun.
3. **Skill Baru Paling Berharga:** Menggunakan package sangat berguna untuk menjadikan file-file kode menjadi lebih rapi. Refactoring Code yg saya lakukan merupakan hal yang baru bagi saya, masih agak susah untuk dimengerti.

### Refleksi dari Akmal Zaida F.
1. **Momen “Aha!” Terbesar:** Momen dimana kami saling mencari kesalahan dan merefleksi project kami sendiri
2. **Kelemahan Terbesar Saya/Tim:** Kesalahan beberapa pada uml dan kode yang belum di refactory
3.	**Skill Baru Paling Berharga:** Refacftory kode menurut saya berguna untuk dalam dunia profesional