# Kiểm thử phần mềm
repo lưu trữ bài tập và thực hành môn kiểm thử phần mềm

---------------------
## Buổi 1 – Trải nghiệm kiểm thử qua game "Can't Unsee"
Em Nguyễn Hồng Ngọc đã chơi Can't Unsee và đạt 6730 điểm vào buổi học số 1 (ngày 5/1/2026), minh chứng là ảnh chụp màn hình trong repository

-----------------------
## Buổi 2 – Kiểm thử đơn vị với JUnit
công nghệ em sử dụng: java+maven+JUnit 5

### Cấu trúc thư mục
  `src/main/java`: mã nguồn chính
  `src/test/java`: mã kiểm thử đơn vị
### Cách chạy kiểm thử
  ```bash
 ( mvn test)
  ```

-----------------------
## Buổi 3 – Kiểm thử E2E với Cypress
Buổi 3 tập trung vào kiểm thử tự động End-to-End (E2E) cho ứng dụng web bằng công cụ Cypress.
Mục tiêu là mô phỏng luồng hành vi thực tế của người dùng và kiểm tra toàn bộ hệ thống từ giao diện đến chức năng.

### Công nghệ sử dụng
  Node.js
  Cypress (E2E Testing)
  Website thực hành: https://www.saucedemo.com

### Nội dung kiểm thử
Các kịch bản kiểm thử được xây dựng bao gồm:
  Đăng nhập thành công với tài khoản hợp lệ
  Đăng nhập thất bại với thông tin không hợp lệ
  Thêm sản phẩm vào giỏ hàng
  Sắp xếp sản phẩm theo giá (low to high)
  Xóa sản phẩm khỏi giỏ hàng
  Thực hiện quy trình thanh toán (checkout step one)

### Cấu trúc thư mục chính
cypress/
 ├─ e2e/
 │  ├─ login_spec.cy.js
 │  └─ cart_spec.cy.js
 ├─ fixtures/
 └─ support/
cypress.config.js
package.json
package-lock.json

### Cách chạy kiểm thử
Chạy Cypress ở chế độ giao diện:
  npx cypress open

Hoặc chạy toàn bộ test ở chế độ headless:
  npx cypress run

### Kết quả
Tất cả các kịch bản kiểm thử đã được thực thi thành công.
Kết quả chạy test và video (nếu có) được Cypress tự động sinh ra trong quá trình kiểm thử.