package com.tangyu.model;

import java.util.Date;

/****
 * 邮件实体类
 * 
 * @author tangyu
 *
 */
public class Mail {
	private Long id;
	private String title;
	private String content;
	private Long createdUser;
	private Date createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(Long createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Mail [id=" + id + ", title=" + title + ", content=" + content + ", createdUser=" + createdUser
				+ ", createdDate=" + createdDate + "]";
	}

}
