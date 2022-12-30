package labs_examples.datastructures.hashmap.labs;

import labs_examples.datastructures.queue.examples.CustomQueue;

import java.util.*;

/*      HashMaps Exercise_02
 *
 *      Create a new class that does the following:
 *
 *      1) create a LinkedList
 *      2) create a Stack
 *      3) create a Queue
 *      4) create a HashMap
 *
 *      Then, add millisecond timers before and after each data structure above and print out
 *      how long it takes for each to complete EACH the following tasks, and the total time for
 *      each data structure:
 *
 *      1) add 100 elements
 *      2) update 100 elements
 *      3) search for 100 elements
 *      4) delete 100 elements
 */
public class Exercise_03 {
    public static void main(String[] args) {
        /* 1) create a LinkedList */
        System.out.println("**Starting LinkedList.**");
        long startTimeLinkedList = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 1) add 100 elements
        long startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            linkedList.push(i);
        }
        long linkedListAddDuration = System.nanoTime() - startTimeTask;
        System.out.println("LinkedList add duration: " + linkedListAddDuration);
        TaskDurations linkedListAdd = new TaskDurations("LinkedList Add", linkedListAddDuration, false);

        // 2) update 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            linkedList.set(i, i * i);
        }
        long LinkedListUpdateDuration = System.nanoTime() - startTimeTask;
        System.out.println("LinkedList update duration: " + LinkedListUpdateDuration);
        TaskDurations linkedListUpdate = new TaskDurations("LinkedList update", LinkedListUpdateDuration, false);

        // 3) search for 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int index = linkedList.indexOf(i * i);
        }
        long LinkedListSearchDuration = System.nanoTime() - startTimeTask;
        System.out.println("LinkedList search duration: " + LinkedListSearchDuration);
        TaskDurations linkedListSearch = new TaskDurations("LinkedList search", LinkedListSearchDuration, false);

        // 4) delete 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            linkedList.remove();
        }
        long LinkedListDeleteDuration = System.nanoTime() - startTimeTask;
        System.out.println("LinkedList delete duration: " + LinkedListDeleteDuration);
        TaskDurations linkedListDelete = new TaskDurations("LinkedList delete", LinkedListDeleteDuration, false);

        long LinkedListDuration = System.nanoTime() - startTimeLinkedList;
        TaskDurations linkedListEnd = new TaskDurations("LinkedList", LinkedListDuration, true);

        /* 2) create a Stack */
        System.out.println("**Starting Stack.**");
        long startTimeStack = System.nanoTime();
        Stack<Integer> stack = new Stack<>();
        // 1) add 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        long stackAddDuration = System.nanoTime() - startTimeTask;
        System.out.println("Stack add duration: " + stackAddDuration);
        TaskDurations stackAdd = new TaskDurations("Stack Add", stackAddDuration, false);

        // 2) update 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            stack.set(i, i * i);
        }
        long stackUpdateDuration = System.nanoTime() - startTimeTask;
        System.out.println("Stack update duration: " + stackUpdateDuration);
        TaskDurations stackUpdate = new TaskDurations("Stack update", stackUpdateDuration, false);

        // 3) search for 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            int index = stack.indexOf(i * i);
        }
        long stackSearchDuration = System.nanoTime() - startTimeTask;
        System.out.println("Stack search duration: " + stackSearchDuration);
        TaskDurations stackSearch = new TaskDurations("Stack search", stackSearchDuration, false);

        // 4) delete 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            stack.pop();
        }
        long stackDeleteDuration = System.nanoTime() - startTimeTask;
        System.out.println("Stack delete duration: " + stackDeleteDuration);
        TaskDurations stackDelete = new TaskDurations("Stack delete", stackDeleteDuration, false);

        long stackDuration = System.nanoTime() - startTimeStack;
        TaskDurations stackEnd = new TaskDurations("Stack", stackDuration, true);

        /* 3) create a Queue */
        System.out.println("**Starting Queue.**");
        long startTimeQueue = System.nanoTime();
        CustomQueue<Integer> customQueue = new CustomQueue<>();
        // 1) add 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            customQueue.enqueue(i);
        }
        long customQueueAddDuration = System.nanoTime() - startTimeTask;
        System.out.println("CustomQueue add duration: " + customQueueAddDuration);
        TaskDurations customQueueAddAdd = new TaskDurations("CustomQueue Add", customQueueAddDuration, false);

        // 2) update 100 elements
        startTimeTask = System.nanoTime();
        //PriorityQueue<Integer> priorityQueueNew = new PriorityQueue<>();
        for (int i = 0; i < 100; i++) {
            customQueue.update(i, i*i);
        }
        long customQueueUpdateDuration = System.nanoTime() - startTimeTask;
        System.out.println("CustomQueue update duration: " + customQueueUpdateDuration);
        TaskDurations customQueueUpdate = new TaskDurations("CustomQueue update", customQueueUpdateDuration, false);

        // 3) search for 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            boolean doesContain = customQueue.contains(i);
        }
        long customQueueSearchDuration = System.nanoTime() - startTimeTask;
        System.out.println("CustomQueue search duration: " + customQueueSearchDuration);
        TaskDurations customQueueSearch = new TaskDurations("CustomQueue search", customQueueSearchDuration, false);

        // 4) delete 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            customQueue.dequeue();
        }
        long customQueueDeleteDuration = System.nanoTime() - startTimeTask;
        System.out.println("CustomQueue delete duration: " + customQueueDeleteDuration);
        TaskDurations customQueueDelete = new TaskDurations("CustomQueue delete", customQueueDeleteDuration, false);

        long customQueueDuration = System.nanoTime() - startTimeStack;
        TaskDurations customQueueEnd = new TaskDurations("CustomQueue", customQueueDuration, true);

        /* 4) create a HashMap */
        System.out.println("**Starting HashMap.**");
        long startTimeHashMap = System.nanoTime();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 1) add 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            hashMap.put(i, i);
        }
        long hashMapAddDuration = System.nanoTime() - startTimeTask;
        System.out.println("HashMap add duration: " + hashMapAddDuration);
        TaskDurations hashMapAdd = new TaskDurations("HashMap Add", hashMapAddDuration, false);

        // 2) update 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            hashMap.replace(i, i * i);
        }
        long hashMapUpdateDuration = System.nanoTime() - startTimeTask;
        System.out.println("HashMap update duration: " + hashMapUpdateDuration);
        TaskDurations hashMapUpdate = new TaskDurations("HashMap update", hashMapUpdateDuration, false);

        // 3) search for 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            boolean containsValue = hashMap.containsValue(i * i);
        }
        long hashMapSearchDuration = System.nanoTime() - startTimeTask;
        System.out.println("HashMap search duration: " + hashMapSearchDuration);
        TaskDurations hashMapSearch = new TaskDurations("HashMap search", hashMapSearchDuration, false);

        // 4) delete 100 elements
        startTimeTask = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            hashMap.remove(i);
        }
        long hashMapDeleteDuration = System.nanoTime() - startTimeTask;
        System.out.println("HashMap delete duration: " + hashMapDeleteDuration);
        TaskDurations hashMapDelete = new TaskDurations("HashMap delete", hashMapDeleteDuration, false);

        long hashMapDuration = System.nanoTime() - startTimeStack;
        TaskDurations hashMapEnd = new TaskDurations("HashMap", stackDuration, true);
    }
}
class TaskDurations{
    private String taskName;
    private long durationNanoseconds;
    private boolean isSection;

    public TaskDurations(String taskName, long durationNanoseconds, boolean isSection) {
        this.taskName = taskName;
        this.durationNanoseconds = durationNanoseconds;
        this.isSection = isSection;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public long getDurationNanoseconds() {
        return durationNanoseconds;
    }

    public void setDurationNanoseconds(int durationNanoseconds) {
        this.durationNanoseconds = durationNanoseconds;
    }

    public boolean isSection() {
        return isSection;
    }

    public void setSection(boolean section) {
        isSection = section;
    }

    @Override
    public String toString() {
        return "TaskDurations{" +
                "taskName='" + taskName + '\'' +
                ", durationNanoseconds=" + durationNanoseconds +
                ", isSection=" + isSection +
                '}';
    }
}