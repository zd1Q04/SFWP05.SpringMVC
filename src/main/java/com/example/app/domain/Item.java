package com.example.app.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Item {

	private String name;
	private Integer price;

//	Postの際、日付をハイフン区切りで送信するように expirationDate フィールドに@DateTimeFormat アノテーションを付与しましょう。
//	@DateTimeFormat アノテーションを付与する代わりに、データ型を java.time.LocalDate に変えることでも対応可能です。

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationDate;

}
