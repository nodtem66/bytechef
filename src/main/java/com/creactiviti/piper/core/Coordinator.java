package com.creactiviti.piper.core;

import java.util.Map;

import com.creactiviti.piper.core.job.Job;
import com.creactiviti.piper.core.task.JobTask;

/**
 * The central interface responsible for coordinating 
 * and executing jobs.
 * 
 * @author Arik Cohen
 * @since Jun 12, 2016
 */
public interface Coordinator {

  /**
   * Starts a job instance.
   * 
   * @param aPipelineId
   *          The ID of the pipeline that will execute the job.
   * @param aInput
   *          A Key-Value map representing the Job's input.
   * @return Job
   *           The instance of the Job
   */
  Job start (String aPipelineId, Map<String, Object> aInput);
  
  /**
   * Stop a running job.
   * 
   * @param aJobId
   *          The id of the job to stop
   */
  Job stop (String aJobId);

  /**
   * Resume a stopped or failed job.
   * 
   * @param aJobId
   *          The id of the job to resume.
   */
  Job resume (String aJobId);

  /**
   * Complete a task of a given job.
   * 
   * @param aTask
   *          The task to complete.
   */
  void complete (JobTask aTask);
  
  /**
   * Handle and erroring task.
   * 
   * @param aTask
   *          The task to handle.
   */
  void error (JobTask aTask);
  
  /**
   * Handles application events. 
   * 
   * @param aEvent
   *          The event to handle
   */
  void on (Object aEvent);
  
}
