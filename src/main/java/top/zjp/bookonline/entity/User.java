package top.zjp.bookonline.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户实体类
 *
 * @author zjp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;
    private String account;
    private String password;
    private String nickname;
    private String avatar;
    private String address;
    private LocalDateTime createTime;
}
