# reporter-salary-management
## Quản lý trả nhuân bút cho phóng viên tòa soạn


Khai báo lớp **Con Người (Họ tên, Địa chỉ, SĐT)**, lớp **Phóng viên kế thừa lớp Con Người (mã PV, Loại phóng viên)** – trong đó loại phóng viên có thể là: chuyên nghiệp, nghiệp dư, cộng tác viên. Mã PV là một số nguyên có 5 chữ số, tự động tăng.  

Khai báo lớp Kiểu **Bài viết (mã kiểu bài, tên kiểu bài, đơn giá)**, mã kiểu bài là một số nguyên có 3 chữ số, tự động tăng.  

Khai báo lớp **Bảng Tính Công** có **quan hệ kết hợp** với lớp **Phóng viên** và **Kiểu bài viết** trong đó một phóng viên sẽ có một số bài viết thuộc các kiểu khác nhau trong tháng (có thể có nhiều bài cùng kiểu và nhiều kiểu bài khác nhau). Giả sử mỗi phóng viên chỉ được tham gia viết tối đa 5 kiểu bài khác nhau.  

Viết chương trình trong ngôn ngữ JAVA thực hiện các yêu cầu sau:  
1.	Nhập danh sách phóng viên. In ra danh sách phóng viên đã có   
2.	Nhập danh sách kiểu bài viết.  In ra danh sách kiểu bài đã có      
3.	Lập Bảng tính công cho phóng viên bằng cách nhập các kiểu bài mà mỗi phóng viên đã viết cùng số lượng tương ứng và in danh sách ra màn hình. (Chú ý: một phóng viên với cùng một kiểu bài không được phép xuất hiện quá một lần trong bảng này)  
4.	Sắp xếp danh sách Bảng tính công     
   a.	Theo Họ tên phóng viên    
   b.	Theo Số lượng bài viết (giảm dần) 
5.	Lập bảng kê thu nhập của mỗi phóng viên  

Giải quyết bài toán dùng Java OOP + các kiến thức cơ bản về lập trình
