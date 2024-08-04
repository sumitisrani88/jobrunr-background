package com.sephora.jobrunr_background.services;

import org.jobrunr.jobs.JobId;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class UserJob {

  @Autowired
  private JobScheduler jobScheduler;


  public void sendWelcomeEmail(){
    //Fire-Forget Jobs
    JobId jobId = jobScheduler.enqueue(() -> new UserMailer().sendWelcomeEmail());
    System.out.println("---Welcome Email Job ID:"+ jobId +"------");
  }

  public void sendVerificationEmail(){
    //Scheduling Jobs in the Future
    JobId jobId = jobScheduler.schedule(LocalDateTime.now().plusMinutes(1), () -> new UserMailer().sendVerificationEmail());
    System.out.println("---Triggered Verification Email Job ID:"+ jobId +"------");
  }

  public void sendReviewReminderEmail(){
    //Scheduling Jobs Recurrently
    jobScheduler.scheduleRecurrently(Cron.minutely(), () -> new UserMailer().sendReviewReminderEmail());
    System.out.println("---Triggered Review Reminder Email Job ID:------");
  }
}
