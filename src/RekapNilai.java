import java.util.Scanner;

public class RekapNilai {
    // Menyimpan sentinel -1 sebagai konstanta static final
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0; // Akumulator untuk rata-rata
        int jumlahSah = 0; // Menghitung berapa nilai yang valid
        int counter = 1; // Menghitung nomor urut input (Nilai ke-...)
        int nilai;

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        // do-while lebih pas dari while karena nilai pertama harus dibaca minimal sekali sebelum bisa dicek apakah itu -1 atau bukan.
        do {
            System.out.print("Nilai ke-" + counter + " : ");
            nilai = input.nextInt();

            // Jika sentinel ditekan, keluar dari loop
            if (nilai == SELESAI) {
                break;
            }

            // Validasi nilai di luar 0-100 dengan continue
            if (nilai < 0 || nilai > 100) {
                System.out.println("  ditolak - nilai harus 0..100");
                continue; // Langsung melompat ke iterasi berikutnya, pencacah tidak naik
            }

            char grade;
            /*
             * Jika urutan dibalik (nilai >= 60 ditaruh paling atas):
             * Nilai 85 akan langsung masuk ke blok >= 60 (kondisi pertama yang true).
             * Akibatnya, nilai 85 akan salah mendapatkan grade 'D', bukan 'B'.
             */
            if (nilai >= 90) {
                grade = 'A';
            } else if (nilai >= 80) {
                grade = 'B';
            } else if (nilai >= 70) {
                grade = 'C';
            } else if (nilai >= 60) {
                grade = 'D';
            } else {
                grade = 'E';
            }

            // Keterangan grade memakai switch lambda (Java 14+)
            String keterangan = switch (grade) {
                case 'A' -> "Sangat Baik";
                case 'B' -> "Baik";
                case 'C' -> "Cukup";
                case 'D' -> "Kurang";
                default -> "Tidak Lulus";
            };

            System.out.println("  Grade " + grade + " - " + keterangan);

            // Tambahkan nilai ke akumulator dan naikkan pencacah karena nilai sah
            total += nilai; // Augmented assignment
            jumlahSah++;
            counter++;

        } while (nilai != SELESAI);

        // Menjaga kasus tidak ada nilai sah sama sekali untuk mencegah pembagian dengan nol
        if (jumlahSah == 0) {
            System.out.println("Tidak ada nilai sah yang dimasukkan.");
        } else {
            double rata = total / jumlahSah;
            // Status kelas ditentukan dengan ternary
            String status = rata >= 60 ? "LULUS" : "TIDAK LULUS";

            System.out.println("Nilai sah  : " + jumlahSah);
            // Menampilkan dua angka di belakang koma
            System.out.println("Rata-rata  : " + String.format("%.2f", rata));
            System.out.println("Status     : " + status);
        }
    }
}