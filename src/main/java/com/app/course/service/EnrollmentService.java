package com.app.course.service;

import com.app.course.model.Enrollment;
import com.app.course.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository repo;

    public EnrollmentService(EnrollmentRepository repo) {
        this.repo = repo;
    }

    public List<Enrollment> getAllEnrollments() {
        return repo.getAllWithCourse();
    }

    public Enrollment saveEnrollment(Enrollment enrollment) {
        return repo.save(enrollment);
    }

    public Enrollment getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }
}
