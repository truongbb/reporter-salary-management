package logic;

import entity.PostType;
import entity.Reporter;
import entity.ReporterManagement;
import entity.ReporterManagementDetail;

import java.util.Scanner;

public class ReporterManagementLogic {

    private ReporterManagement[] reporterManagements;

    private ReporterLogic reporterLogic;
    private PostTypeLogic postTypeLogic;

    public ReporterManagementLogic(ReporterManagement[] reporterManagements,
                                   ReporterLogic reporterLogic,
                                   PostTypeLogic postTypeLogic) {
        this.reporterManagements = reporterManagements;
        this.reporterLogic = reporterLogic;
        this.postTypeLogic = postTypeLogic;
    }

    public void phanCongBaiViet() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin phóng viên hoặc bài viết, vui lòng nhập danh sách phóng viên và bài viết trước");
            return;
        }

        System.out.print("Bạn muốn lập bảng tính công cho bao nhiêu phóng viên: ");
        int soLuongPhongVien;
        do {
            soLuongPhongVien = new Scanner(System.in).nextInt();
            if (soLuongPhongVien > 0 && soLuongPhongVien <= reporterLogic.getTotalReporter()) {
                break;
            }
            System.out.println("Số lượng phóng viên phân công cần phải là số dương và nhỏ hơn số lượng phóng viên có trong tòa soạn");
        } while (true);
        for (int i = 0; i < soLuongPhongVien; i++) {
            // nhập ông phóng viên muốn lập bảng công
            System.out.print("Phóng viên thứ " + (i + 1) + " muốn lập bảng tính công là PV nào, nhập ID phóng viên: ");
            Reporter phongVien = nhapPhongVien();

            // hỏi xem ông này muốn lập bảng tính công ở mấy thể loại bài viết
            System.out.print("Bạn muốn lập bảng tính công cho bao nhiêu loại bài viết: ");
            int soLoaiBaiViet;
            do {
                soLoaiBaiViet = new Scanner(System.in).nextInt();
                if (soLoaiBaiViet >= 1 && soLoaiBaiViet <= 5 && soLoaiBaiViet <= postTypeLogic.getTotalPostType()) {
                    break;
                }
                System.out.print("Số loại bài viết phải là số dương và nhỏ hơn tổng số lượng bài viết mà tòa soạn đang có, đồng thời phải nhỏ hơn hoặc bẳng 5, vui lòng nhập lại: ");
            } while (true);

            // lập danh sách các thể loại mà ông này viết bài và số lượng bài viết tương ứng
            ReporterManagementDetail[] danhSachLoaiBaiViet = nhapDanhSachLoaiBaiViet(soLoaiBaiViet);

            // thêm dữ liệu phóng viên + danh sách bài viết mà phóng viên đó viết vào trong 1 cái mảng
            ReporterManagement phanCong = new ReporterManagement(phongVien, danhSachLoaiBaiViet);
            saveReportManagement(phanCong);
        }

        showReporterManagement();
    }

    private void showReporterManagement() {
        for (int i = 0; i < reporterManagements.length; i++) {
            if (reporterManagements[i] != null) {
                System.out.println(reporterManagements[i]);
            }
        }
    }

    private ReporterManagementDetail[] nhapDanhSachLoaiBaiViet(int soLoaiBaiViet) {
        ReporterManagementDetail[] danhSachLoaiBaiViet = new ReporterManagementDetail[soLoaiBaiViet];
        for (int j = 0; j < soLoaiBaiViet; j++) {
            System.out.print("Nhập thông tin cho loại bài viết thứ " + (j + 1) + ", nhập ID loại bài viết: ");

            int idLoaiBaiViet;
            PostType loaiBaiViet;
            // tìm kiếm xem loại bài viết này có trong hệ thống tòa soạn của mình không

            do {
                idLoaiBaiViet = new Scanner(System.in).nextInt();
                loaiBaiViet = postTypeLogic.searchById(idLoaiBaiViet);
                if (loaiBaiViet != null) {
                    break;
                }
                System.out.print("Không tìm thấy loại bài nào có mã " + idLoaiBaiViet + ", vui lòng nhập lại: ");
            } while (true);

            System.out.print("Trong tháng vừa rồi, ông viết được mấy bài thuộc thể loại này: ");
            int soLuongBaiCuaLoaiNay = new Scanner(System.in).nextInt();

            ReporterManagementDetail detail = new ReporterManagementDetail(loaiBaiViet, soLuongBaiCuaLoaiNay);
            saveLoaiBaiVietChiTiet(detail, danhSachLoaiBaiViet);
        }
        return danhSachLoaiBaiViet;
    }

    private Reporter nhapPhongVien() {
        int idPhongVien;
        Reporter phongVien;
        // tìm kiếm xem phóng viên này có trong hệ thống tòa soạn của mình không

        do {
            idPhongVien = new Scanner(System.in).nextInt();
            phongVien = reporterLogic.searchById(idPhongVien);
            if (phongVien != null) {
                break;
            }
            System.out.print("Không tìm thấy phóng viên có mã " + idPhongVien + ", vui lòng nhập lại: ");
        } while (true);
        return phongVien;
    }

    private void saveReportManagement(ReporterManagement phanCong) {
        for (int i = 0; i < reporterManagements.length; i++) {
            if (reporterManagements[i] == null) {
                reporterManagements[i] = phanCong;
                break;
            }
        }
    }

    private void saveLoaiBaiVietChiTiet(ReporterManagementDetail detail, ReporterManagementDetail[] danhSachLoaiBaiViet) {
        for (int i = 0; i < danhSachLoaiBaiViet.length; i++) {
            if (danhSachLoaiBaiViet[i] == null) {
                danhSachLoaiBaiViet[i] = detail;
                break;
            }
        }
    }

    public void sortByReporterName() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin phóng viên hoặc bài viết, vui lòng nhập danh sách phóng viên và bài viết trước");
            return;
        }
        for (int i = 0; i < reporterManagements.length - 1; i++) {
            if (reporterManagements[i] == null) {
                continue;
            }
            for (int j = i + 1; j < reporterManagements.length; j++) {
                if (reporterManagements[j] == null) {
                    continue;
                }
                if (reporterManagements[i].getReporter().getName().trim().compareToIgnoreCase(reporterManagements[j].getReporter().getName().trim()) > 0) {
                    ReporterManagement temp = reporterManagements[i];
                    reporterManagements[i] = reporterManagements[j];
                    reporterManagements[j] = temp;
                }
            }
        }
        showReporterManagement();
    }

    public void sortByPostNumber() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin phóng viên hoặc bài viết, vui lòng nhập danh sách phóng viên và bài viết trước");
            return;
        }
        for (int i = 0; i < reporterManagements.length - 1; i++) {
            if (reporterManagements[i] == null) {
                continue;
            }
            for (int j = i + 1; j < reporterManagements.length; j++) {
                if (reporterManagements[j] == null) {
                    continue;
                }
                if (reporterManagements[i].getTotalPost() < reporterManagements[j].getTotalPost()) {
                    ReporterManagement temp = reporterManagements[i];
                    reporterManagements[i] = reporterManagements[j];
                    reporterManagements[j] = temp;
                }
            }
        }
        showReporterManagement();
    }

    public void tinhThuNhap() {
        if (!coDuLieuHayChua()) {
            System.out.println("Chưa có thông tin phóng viên hoặc bài viết, vui lòng nhập danh sách phóng viên và bài viết trước");
            return;
        }
        for (int i = 0; i < reporterManagements.length; i++) {
            double tongThuNhap = 0;
            ReporterManagement baoCaoBaiViet = reporterManagements[i];
            ReporterManagementDetail[] danhSachBaiViet = baoCaoBaiViet.getReporterManagementDetails();
            for (int j = 0; j < danhSachBaiViet.length; j++) {
                tongThuNhap += danhSachBaiViet[j].getPostType().getPrice() * danhSachBaiViet[j].getQuantity();
            }
            System.out.println("Tổng thu nhập của ông " + reporterManagements[i].getReporter().getName() + " là " + tongThuNhap);
        }
    }

    private boolean coDuLieuHayChua() {
        boolean coDuLieuPhongVien = false;
        for (int i = 0; i < reporterLogic.getReporters().length; i++) {
            if (reporterLogic.getReporters()[i] != null) {
                coDuLieuPhongVien = true;
                break;
            }
        }

        boolean coDuLieuBaiViet = false;
        for (int i = 0; i < postTypeLogic.getPostTypes().length; i++) {
            if (postTypeLogic.getPostTypes()[i] != null) {
                coDuLieuBaiViet = true;
                break;
            }
        }

        return coDuLieuPhongVien && coDuLieuBaiViet;
    }

}
