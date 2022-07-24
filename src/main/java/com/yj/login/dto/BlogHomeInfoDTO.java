package com.yj.login.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客首页信息
 *
 * @author kris
 * @date 2022/07/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogHomeInfoDTO {
/**
 * 文章数量
 */
private Integer articleCount;
}
