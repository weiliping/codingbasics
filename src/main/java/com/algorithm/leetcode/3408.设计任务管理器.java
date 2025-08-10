/*
 * @lc app=leetcode.cn id=3408 lang=java
 *
 * [3408] 设计任务管理器
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
class Task {
    int userId;
    int taskId;
    int priority;

    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }
}
class TaskManager {
    Map<Integer, Task> taskMap = new HashMap<>();
    Map<Integer, PriorityQueue<Task>> userTaskQueues = new HashMap<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            Task t = new Task(userId, taskId, priority);
            taskMap.put(taskId, t);
            if (!userTaskQueues.containsKey(priority)) {
                userTaskQueues.put(priority, new PriorityQueue<>((a, b) -> b.taskId - a.taskId));
                priorityQueue.offer(priority);
            }
            userTaskQueues.get(priority).offer(t);
        }    
    }
    
    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        taskMap.put(taskId, t);
        if (!userTaskQueues.containsKey(priority)) {
            userTaskQueues.put(priority, new PriorityQueue<>((a, b) -> b.taskId - a.taskId));
            priorityQueue.offer(priority);
        }
        userTaskQueues.get(priority).offer(t);
    }
    
    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        rmv(taskId); // Remove the old task from the map
        add(oldTask.userId, taskId, newPriority); // Re-add the task with the new priority
    }
    
    public void rmv(int taskId) {
        Task oldTask = taskMap.get(taskId);
        PriorityQueue<Task> oldQueue = userTaskQueues.get(oldTask.priority);
        oldQueue.remove(oldTask); // Remove the old task from its current queue
        
        if (oldQueue.isEmpty()) {
            userTaskQueues.remove(oldTask.priority); // Remove the queue if it's empty
            priorityQueue.remove(Integer.valueOf(oldTask.priority)); // Remove the priority if no tasks left
        } else {
            userTaskQueues.put(oldTask.priority, oldQueue); // Update the queue in the map
        }

        taskMap.remove(taskId); // Remove the task from the map    
    }
    
    public int execTop() {
        if (priorityQueue.isEmpty()) {
            return -1; // No tasks available
        }
        Integer topPriority = priorityQueue.peek(); // Get the highest priority
        
        PriorityQueue<Task> taskQueue = userTaskQueues.get(topPriority);
        Task topTask = taskQueue.poll(); // Get the task with the highest priority
        if (taskQueue.isEmpty()) {
            userTaskQueues.remove(topPriority);
            priorityQueue.poll(); // Remove the queue if it's empty
        }
        taskMap.remove(topTask.taskId); // Remove it from the map
        return topTask.userId; // Return the taskId of the executed task    
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
// @lc code=end

