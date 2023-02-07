package com.ssafy.bundler.domain;

import static jakarta.persistence.FetchType.*;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Entity
@Table(name = "FEEDS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "feed_type", discriminatorType = DiscriminatorType.STRING)
public class Feed extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feed_id")
	private Long feedId;

	@Column(name = "feed_title")
	private String feedTitle;

	@Column(name = "feed_content")
	private String feedContent;

	@Column(name = "feed_like_cnt")
	private int feedLikeCnt;

	// @Column(name = "feed_type")
	// @Enumerated(EnumType.STRING)
	// @NaturalId
	// private FeedType feedType;

	@Column(name = "feed_comment_cnt")
	private int feedCommentCnt;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	//////////////////////////

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "user_id")
	private User writer;

	// @OneToOne
	// private Card card;

	// @OneToOne
	// private Bundle bundle;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "feed_id")
	private List<Comment> commentList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "feed_id")
	private List<FeedCategory> feedCategoryList;

	//===== 로그인 사용자 =====//

	//사용자가 좋아요한 피드
	@Transient
	private boolean isFeedLiked;

}
