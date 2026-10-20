package io.github.oranui.job_tracker.application;

import io.github.oranui.job_tracker.global.entity.BaseTimeEntity;
import io.github.oranui.job_tracker.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "applications")
public class Application extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String title;

    @Column(nullable = false, length = 100)
    private String companyName;

    @Column(nullable = false, length = 100)
    private String position;

    @Column(length = 500)
    private String postingUrl;

    @Column(nullable = false)
    private LocalDate appliedDate;

    private LocalDate deadline;

    @Column(columnDefinition = "TEXT")
    private String memo;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private Stage currentStage;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
