package com.ssafy.bundler.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
	value = {"createdAt", "updatedAt"},
	allowGetters = true
)
public abstract class BaseEntity {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// protected Long id;

	@CreatedDate
	@Column(name = "created_at")
	// @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	// @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updatedAt;
}
