package com.jdbc.hw.controller;

import java.util.List;

import com.jdbc.hw.model.service.JobService;
import com.jdbc.hw.model.vo.Job;
import com.jdbc.hw.view.MainView;

public class JobController {
	JobService service = new JobService();

	public void searchAll() {
		List<Job> list = service.searchAll();
		
		if(list.size() > 0)
			new MainView().displayList(list);
		else
			new MainView().displayMsg("NO JOB SEARCH RESULT...");
	}
	
	public void insertJob() {
		this.searchAll();
		
		Job job = new MainView().insertViewJob();
		int result = service.insertJob(job);
		
		if(result > 0)
			new MainView().displayMsg(result + " ROW(s) INSERT COMPLETE.");
		else
			new MainView().displayMsg("JOB INSERT FAILED.");
		
	}

	public void updateJob() {
		this.searchAll();
		
		Job job = new MainView().updateViewJob();
		int result = service.updateJob(job);

		if(result > 0)
			new MainView().displayMsg(result + " ROW(s) UPDATE COMPLETE.");
		else
			new MainView().displayMsg("JOB UPDATE FAILED.");
		
	}
	
	public void deleteJob() {
		this.searchAll();
		
		String jobCode = new MainView().deleteViewJob();
		int result = service.deleteJob(jobCode);

		if(result > 0)
			new MainView().displayMsg(result + " ROW(s) DELETE COMPLETE.");
		else
			new MainView().displayMsg("JOB DELETE FAILED.");
		
	}
}
