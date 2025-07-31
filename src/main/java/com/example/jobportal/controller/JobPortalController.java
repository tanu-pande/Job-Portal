package com.example.jobportal.controller;

import com.example.jobportal.model.Job;
import com.example.jobportal.model.JobApplication;
import com.example.jobportal.repository.JobApplicationRepository;
import com.example.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobPortalController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobApplicationRepository applicationRepository;

    // ✅ Home Page
    @GetMapping("/")
    public String home() {
        return "home"; // home.html
    }

    // ✅ Login Page
    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }

    // ✅ Handle login POST
    @PostMapping("/login")
    public String processLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        // 🔒 Dummy check — replace with DB validation logic later
        if ("admin".equals(username) && "admin".equals(password)) {
            return "dashboard"; // dashboard.html
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // login.html
        }
    }

    // ✅ Register Page
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // register.html
    }

    // ✅ Dummy Register Success
    @PostMapping("/register")
    public String processRegister() {
        return "register_success"; // register_success.html
    }

    // ✅ Dashboard after login
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // dashboard.html
    }

    // ✅ Show job posting form
    @GetMapping("/jobs/new")
    public String showJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "post_job"; // post_job.html
    }

    // ✅ Save job from post form
    @PostMapping("/jobs")
    public String saveJob(@ModelAttribute Job job) {
        jobRepository.save(job);
        return "redirect:/dashboard";
    }

    // ✅ List all jobs
    @GetMapping("/jobs")
    public String listJobs(Model model) {
        List<Job> jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);
        return "jobs"; // jobs.html
    }

    // ✅ Show application form
    @GetMapping("/jobs/{id}/apply")
    public String showApplicationForm(@PathVariable("id") Long jobId, Model model) {
        Optional<Job> jobOpt = jobRepository.findById(jobId);
        if (jobOpt.isPresent()) {
            model.addAttribute("job", jobOpt.get());
            return "apply_form"; // apply_form.html
        } else {
            return "redirect:/jobs?error=JobNotFound";
        }
    }

    // ✅ Submit job application
    @PostMapping("/jobs/{id}/apply")
    public String submitApplication(
            @PathVariable("id") Long jobId,
            @RequestParam("applicantName") String applicantName,
            @RequestParam("applicantEmail") String applicantEmail,
            @RequestParam("message") String message,
            Model model) {

        Optional<Job> jobOpt = jobRepository.findById(jobId);
        if (jobOpt.isPresent()) {
            JobApplication application = new JobApplication();
            application.setJob(jobOpt.get());
            application.setApplicantName(applicantName);
            application.setApplicantEmail(applicantEmail);
            application.setMessage(message);

            applicationRepository.save(application);

            model.addAttribute("job", jobOpt.get());
            model.addAttribute("success", "Application submitted successfully!");
            return "apply_success"; // apply_success.html
        } else {
            return "redirect:/jobs?error=JobNotFound";
        }
    }

    // ✅ View all applications
    @GetMapping("/applications")
    public String viewAllApplications(Model model) {
        List<JobApplication> applications = applicationRepository.findAll();
        model.addAttribute("applications", applications);
        return "applications"; // applications.html
    }

    // ✅ View user list
    @GetMapping("/users")
    public String viewUsers() {
        return "users"; // users.html
    }
}
