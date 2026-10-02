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