package com.sephora.jobrunr_background.services;

import org.jobrunr.jobs.annotations.Job;
import org.springframework.stereotype.Service;

@Service
public class UserMailer {

  @Job(name = "Send Welcome Aboard Email")
  public void sendWelcomeEmail(){
    System.out.println("-------Welcome Aboard User------");
  }

  @Job(name = "Send Verification Email")
  public void sendVerificationEmail(){
    System.out.println("-------Verify your email------");
  }

  @Job(name = "Send Review Reminder Email every minute cron")
  public void sendReviewReminderEmail(){
    System.out.println("-------Review reminder email------");
  }
}
