package baitap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DoAnMeNu {

    static class Sach {
        private String maSach;
        private String tenSach;
        private String tacGia;
        private int namXuatBan;

        public Sach(String maSach, String tenSach, String tacGia, int namXuatBan) {
            this.maSach = maSach;
            this.tenSach = tenSach;
            this.tacGia = tacGia;
            this.namXuatBan = namXuatBan;
        }

        public String getMaSach() {
            return maSach;
        }

        public String getTenSach() {
            return tenSach;
        }

        public String getTacGia() {
            return tacGia;
        }

        public int getNamXuatBan() {
            return namXuatBan;
        }
    } 

    static class ThuVien {
        private ArrayList<Sach> danhSachSach;

        public ThuVien() {
            danhSachSach = new ArrayList<>();
        }

        public void nhapSach() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập mã sách: ");
            String maSach = scanner.nextLine();
            System.out.print("Nhập tên sách: ");
            String tenSach = scanner.nextLine();
            System.out.print("Nhập tác giả: ");
            String tacGia = scanner.nextLine();
            System.out.print("Nhập năm xuất bản: ");
            int namXuatBan = scanner.nextInt();
            scanner.nextLine(); 

            Sach sach = new Sach(maSach, tenSach, tacGia, namXuatBan);
            danhSachSach.add(sach);

            System.out.println("Đã thêm sách thành công!");
        }

        public void hienThiSach() {
            System.out.println("===== DANH SÁCH SÁCH TRONG THƯ VIỆN ============");
            for (Sach sach : danhSachSach) {
                System.out.println("Mã sách: " + sach.getMaSach());
                System.out.println("Tên sách: " + sach.getTenSach());
                System.out.println("Tác giả: " + sach.getTacGia());
                System.out.println("Năm xuất bản: " + sach.getNamXuatBan());
                System.out.println("================================================");
            }
        }

        public void timKiemSach() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập thông tin tìm kiếm (mã sách hoặc tên sách): ");
            String timKiem = scanner.nextLine();
            boolean found = false;
            for (Sach sach : danhSachSach) {
                if (sach.getMaSach().equalsIgnoreCase(timKiem) || sach.getTenSach().toLowerCase().contains(timKiem.toLowerCase())) {
                    System.out.println("===== KẾT QUẢ TÌM KIẾM =====");
                    System.out.println("Mã sách: " + sach.getMaSach());
                    System.out.println("Tên sách: " + sach.getTenSach());
                    System.out.println("Tác giả: " + sach.getTacGia());
                    System.out.println("Năm xuất bản: " + sach.getNamXuatBan());
                    System.out.println("=============================");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy sách!");
            }
        }

        public void themSach() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập mã sách cần thêm: ");
            String maSach = scanner.nextLine();

            for (Sach sach : danhSachSach) {
                if (sach.getMaSach().equals(maSach)) {
                    System.out.println("Sách đã tồn tại trong thư viện!");
                    return;
                }
            }

            System.out.print("Nhập tên sách cần thêm: ");
            String tenSach = scanner.nextLine();
            System.out.print("Nhập tác giả của sách cần thêm: ");
            String tacGia = scanner.nextLine();
            System.out.print("Nhập năm xuất bản của sách cần thêm: ");
            int namXuatBan = scanner.nextInt();
            scanner.nextLine(); 

            Sach sach = new Sach(maSach, tenSach, tacGia, namXuatBan);
            danhSachSach.add(sach);

            System.out.println("Đã thêm sách thành công!");
        }
       
        public void suaSach() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập mã sách cần sửa: ");
            String maSach = scanner.nextLine();

            Sach sachCanSua = null;
            for (Sach sach : danhSachSach) {
                if (sach.getMaSach().equals(maSach)) {
                    sachCanSua = sach;
                    break;
                }
            }

            if (sachCanSua == null) {
                System.out.println("Không tìm thấy sách trong thư viện!");
                return;
            }

            System.out.print("Nhập tên sách mới: ");
            String tenSach = scanner.nextLine();
            System.out.print("Nhập tác giả mới: ");
            String tacGia = scanner.nextLine();
            System.out.print("Nhập năm xuất bản mới: ");
            int namXuatBan = scanner.nextInt();
            scanner.nextLine(); 

            
            sachCanSua.tenSach = tenSach;
            sachCanSua.tacGia = tacGia;
            sachCanSua.namXuatBan = namXuatBan;

            System.out.println("Đã sửa sách thành công!");
        }

        public void xoaSach() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập mã sách cần xóa: ");
            String maSach = scanner.nextLine();

            Sach sachCanXoa = null;
            for (Sach sach : danhSachSach) {
                if (sach.getMaSach().equals(maSach)) {
                    sachCanXoa = sach;
                    break;
                }
            }

            if (sachCanXoa == null) {
                System.out.println("Không tìm thấy sách trong thư viện!");
                return;
            }

            danhSachSach.remove(sachCanXoa);

            System.out.println("Đã xóa sách thành công!");
        }
        
        public void xuatSachToFile() {
            try {
                FileWriter writer = new FileWriter("danh_sach_sach.txt");
                for (Sach sach
                		: danhSachSach) {
                    writer.write("Mã sách: " + sach.getMaSach() + "\n");
                    writer.write("Tên sách: " + sach.getTenSach() + "\n");
                    writer.write("Tác giả: " + sach.getTacGia() + "\n");
                    writer.write("Năm xuất bản: " + sach.getNamXuatBan() + "\n");
                    writer.write("=========================================\n");
                }
                writer.close();
                System.out.println("Đã xuất danh sách sách ra file thành công!");
            } catch (IOException e) {
                System.out.println("Đã xảy ra lỗi khi xuất file: " + e.getMessage());
            }
        }

        public void thongKeSach() {
            System.out.println("===== THỐNG KÊ SÁCH THEO NĂM XUẤT BẢN =====");
            Map<Integer, Integer> thongKe = new HashMap<>();
            for (Sach sach : danhSachSach) {
                int namXuatBan = sach.getNamXuatBan();
                thongKe.put(namXuatBan, thongKe.getOrDefault(namXuatBan, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : thongKe.entrySet()) {
                System.out.println("Năm " + entry.getKey() + ": " + entry.getValue() + " cuốn");
            }
        }
    }

    public static void main(String[] args) {
        ThuVien thuVien = new ThuVien();
        Scanner scanner = new Scanner(System.in);
        while (true) { 
            System.out.println("+----- MENU QUẢN LÝ THƯ VIỆN ----------+");
            System.out.println("|1. Nhập sách                          |");
            System.out.println("|2. Hiển thị sách                      |");
            System.out.println("|3. Tìm kiếm sách                      |");
            System.out.println("|4. Thêm sách                          |");
            System.out.println("|5. Thống kê sách theo năm xuất bản    |");
            System.out.println("|6. Sửa sách                           |");
            System.out.println("|7. Xóa sách                           |");
            System.out.println("|8. Xuất ra File                       |");
            System.out.println("|0. Thoát                              |");
            System.out.println("+--------------------------------------+");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    thuVien.nhapSach();
                    break;
                case 2:
                    thuVien.hienThiSach();
                    break;
                case 3:
                    thuVien.timKiemSach();
                    break;
                case 4:
                    thuVien.themSach();
                    break;
                case 5:
                    thuVien.thongKeSach();
                    break;
                case 6:
                    thuVien.suaSach();
                    break;
                case 7:
                    thuVien.xoaSach();
                    break;    
                case 8:
                    thuVien.xuatSachToFile();
                    break;
                case 0:
                    System.out.println("Chương Trình Kết Thúc !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

            System.out.println();
        }
    }
}
