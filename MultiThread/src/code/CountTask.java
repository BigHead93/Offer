package code;

import java.util.concurrent.*;

public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;
    private int start, end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阈值，就分裂成两个子任务进行计算
            int middle = (start + end) /2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，得到结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 10000);
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
            System.out.println(System.currentTimeMillis() - start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        start = System.currentTimeMillis();
        int sum = 0;
        for(int i = 0; i <= 10000; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start);
    }
}
