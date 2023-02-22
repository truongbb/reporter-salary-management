package logic;

import entity.PostType;

import java.util.Scanner;

public class PostTypeLogic {

    private PostType[] postTypes;

    private int totalPostType;

    public int getTotalPostType() {
        return totalPostType;
    }

    public PostTypeLogic(PostType[] postTypes) {
        this.postTypes = postTypes;
    }

    public PostType[] getPostTypes() {
        return postTypes;
    }

    public void addNewReportType() {
        System.out.print("Nhập số lượng loại bài viết muốn thêm mới: ");
        int num = new Scanner(System.in).nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("Nhập thông tin cho loại bài viết thứ " + (i + 1));
            PostType postType = new PostType();
            postType.inputInfo();
            savePostType(postType);
            System.out.println("----------------------");
        }
        totalPostType += num;
    }

    private void savePostType(PostType t) {
        for (int i = 0; i < postTypes.length; i++) {
            if (postTypes[i] == null) {
                postTypes[i] = t;
                break;
            }
        }
    }

    public void showPostType() {
        for (int i = 0; i < postTypes.length; i++) {
            if (postTypes[i] != null) {
                System.out.println(postTypes[i]);
            }
        }
    }

    public PostType searchById(int id) {
        PostType ketQua = null;
        for (int k = 0; k < postTypes.length; k++) {
            if (postTypes[k] != null && postTypes[k].getId() == id) {
                ketQua = postTypes[k];
                break;
            }
        }
        return ketQua;
    }

}
