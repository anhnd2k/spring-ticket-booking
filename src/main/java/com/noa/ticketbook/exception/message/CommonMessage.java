package com.noa.ticketbook.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CommonMessage implements DomainMessage{
    SUCCESS("RB-000", "Success",HttpStatus.OK),
    INTERNAL_SERVER_ERROR("RB-001", "Hệ thống tạm thời gặp sự cố", HttpStatus.INTERNAL_SERVER_ERROR),
    TOKEN_EXPIRED("RB-002", "Phiên đăng nhập hết hạn", HttpStatus.UNAUTHORIZED),
    TOKEN_INVALID("RB-003", "Phiên đăng nhập không hợp lệ", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED("RB-004", "Chưa thực hiện phiên đăng nhập", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("RB-005", "Không có quyền truy cập tài nguyên này", HttpStatus.FORBIDDEN),
    NOTFOUND("RB-006", "Không tìm thấy tài nguyên này", HttpStatus.NOT_FOUND),
    BAD_REQUEST("RB-007", "Yêu cầu không hợp lệ", HttpStatus.BAD_REQUEST),
    FIELD_INVALID("RB-008", "Trường %s còn thiếu hoặc không hợp lệ", HttpStatus.BAD_REQUEST),
    METHOD_NOT_ALLOWED("RB-009", "Phương thức không hỗ trợ", HttpStatus.METHOD_NOT_ALLOWED),
    ERR_APPROVAL_PROCESS_NOT_FOUND("RB-010", "Lỗi không tìm thấy yêu cầu luồng phê duyệt", HttpStatus.BAD_REQUEST),
    ERR_APPROVAL_PROCESSING("RB-011", "Lỗi luồng phê duyệt đang xử lý", HttpStatus.BAD_REQUEST),
    ERR_DRAFTING_PROCESS("RB-012", "Lỗi tạo yêu cầu từ phê duyệt do người dùng đang soạn thảo hồ sơ", HttpStatus.BAD_REQUEST),
    ERR_DRAFTING_NOT_FOUND("RB-013", "Lỗi không tìm thấy hồ sơ soạn thảo", HttpStatus.BAD_REQUEST),
    ERR_CREATE_CHECKLIST("RB-014", "Lỗi tạo mới danh mục hồ sơ", HttpStatus.BAD_REQUEST),
    ERR_SUBMIT_APPLICANT_NOT_FOUND("RB-015", "Lỗi không tìm thấy thông tin khách hàng của hồ sơ", HttpStatus.BAD_REQUEST),
    ERR_SUBMIT_APPLICANT_OWNER_NOT_FOUND("RB-016", "Lỗi không tìm thấy thông tin khách hàng", HttpStatus.BAD_REQUEST),
    ERR_SUBMIT_BRANCH_CODE_NOT_BLANK("RB-017", "Lỗi thông tin chi nhánh không được để trống", HttpStatus.BAD_REQUEST),
    ERR_SUBMIT_LEGAL_NOT_BLANK("RB-018", "Lỗi thông tin đại diện không được để trống", HttpStatus.BAD_REQUEST),
    ERR_SUBMIT_LOAN_NOT_FOUND("RB-019", "Lỗi không tìm thấy thông tin khoản vay", HttpStatus.BAD_REQUEST),
    ERR_SUBMIT_LOAN_AMOUNT_GREATER("RB-020", "Lỗi khoản vay đề nghị vướt quá hạn mức được cấp", HttpStatus.BAD_REQUEST),
    ERR_SUBMIT_LOAN_DISBURSEMENT_NO("RB-021", "Lỗi khoản vay số lần giải ngân để trống", HttpStatus.BAD_REQUEST),
    ERR_GET_CUSTOMER_INFO_BDS_CLIENT("RB-022", "Lỗi không tìm thấy thông tin khách hàng trên BDS", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_PARAMETER("RB-023","Tham số không hợp lệ hoặc thiếu thông tin", HttpStatus.BAD_REQUEST),
    FILE_NOT_FOUND("RB-024", "File không tồn tại", HttpStatus.BAD_REQUEST),
    ERR_GET_TEMPLATES("RB-025", "Lỗi lấy thông tin template biểu mẫu", HttpStatus.INTERNAL_SERVER_ERROR),
    ERR_EMPTY_LOAN("RB-026", "Bạn chưa chọn thông tin Khoản vay để soạn thảo", HttpStatus.BAD_REQUEST),
    ERR_NOTFOUND_PROJECT("RB-027", "Không tồn tại Dự Án", HttpStatus.BAD_REQUEST),
    ERR_NOTFOUND_PROCURING_AGENCY("RB-028", "Không tồn tại Chủ đầu tư", HttpStatus.BAD_REQUEST),
    ERR_ROLLBACK_CA_FROM_MERCURY("RB-029", "Lỗi trả về CA", HttpStatus.BAD_REQUEST),
    ERR_CURRENT_USER_ROLE_NOT_ACCEPT("RB-030", "Lỗi không xác định được quyền của người xử lý", HttpStatus.BAD_REQUEST),
    ERR_GET_GET_LEGAL_REPRESENTATION("RB-031", "Lỗi lấy thông tin đại diện User", HttpStatus.INTERNAL_SERVER_ERROR),
    ERR_GET_CHECKLIST("RB-032", "Lỗi lấy checklist của hồ sơ", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND("UF-404", "Người dùng không tồn tại!", HttpStatus.BAD_REQUEST);
    private String code;
    private String message;
    private HttpStatus statusCode;
}
