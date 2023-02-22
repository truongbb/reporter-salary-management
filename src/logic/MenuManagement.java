package logic;

import entity.PostType;
import entity.Reporter;
import entity.ReporterManagement;

import java.util.Scanner;

public class MenuManagement {

    private ReporterLogic reporterLogic;
    private PostTypeLogic postTypeLogic;
    private ReporterManagementLogic reporterManagementLogic;

    public MenuManagement() {
        Reporter[] reporters = new Reporter[1000];
        reporterLogic = new ReporterLogic(reporters);

        PostType[] postTypes = new PostType[1000];
        postTypeLogic = new PostTypeLogic(postTypes);

        ReporterManagement[] reporterManagements = new ReporterManagement[1000];
        reporterManagementLogic = new ReporterManagementLogic(reporterManagements, reporterLogic, postTypeLogic);
    }

    public void menu() {
        while (true) {
            showMenu();
            int functionChoice = chooseFunction();
            switch (functionChoice) {
                case 1:
                    reporterLogic.addNewReporter();
                    break;
                case 2:
                    reporterLogic.showReporters();
                    break;
                case 3:
                    postTypeLogic.addNewReportType();
                    break;
                case 4:
                    postTypeLogic.showPostType();
                    break;
                case 5:
                    reporterManagementLogic.phanCongBaiViet();
                    break;
                case 6:
                    showMenuSort();
                    break;
                case 7:
                    reporterManagementLogic.tinhThuNhap();
                    break;
                case 8:
                    return;
            }
        }
    }

    private void showMenuSort() {
        System.out.println("Chọn chức năng mong muốn: ");
        System.out.println("1. Sắp xếp theo họ tên phóng viên");
        System.out.println("2. Sắp xếp số lượng bài viết giảm dần");

        int choice = 0;
        System.out.print("Xin mời nhập lựa chọn: ");
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice == 1 || choice == 2) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);

        if (choice == 1) {
            reporterManagementLogic.sortByReporterName();
        } else {
            reporterManagementLogic.sortByPostNumber();
        }
    }

    private int chooseFunction() {
        int choice = 0;
        System.out.print("Xin mời nhập lựa chọn: ");
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 8) {
                break;
            }
            System.out.print("Chức năng không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return choice;
    }

    private void showMenu() {
        System.out.println("=============PHẦN MỀM QUẢN LÝ TRẢ NHUẬN BÚT CHO PHÓNG VIÊN============");
        System.out.println("1. Thêm danh sách phóng viên mới.");
        System.out.println("2. Hiển thị danh sách phóng viên.");
        System.out.println("3. Thêm danh sách kiểu bài viết mới.");
        System.out.println("4. Hiển thị danh sách kiểu bài viết.");
        System.out.println("5. Lập bảng tính công cho phóng viên");
        System.out.println("6. Sắp xếp bảng tính công");
        System.out.println("7. Tính thu nhập cho các phóng viên");
        System.out.println("8. Thoát");
    }


}
