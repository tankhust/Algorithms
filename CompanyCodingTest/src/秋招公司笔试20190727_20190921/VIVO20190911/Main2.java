package 秋招公司笔试20190727_20190921.VIVO20190911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tankInternshipInterview
 * @create 2019/09/11 16:56
 */
public class Main2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        String[] input = inputStr.split(" ");
        int totalDisk = Integer.parseInt(input[0]);
        int totalMemory = Integer.parseInt(input[1]);
        List<Service> services = parseServices(input[2].split("#"));
        int output = solution(totalDisk, totalMemory, services);
        System.out.println(output);
    }

    private static int solution(int totalDisk, int totalMemory, List<Service> services) {

        // TODO Write your code here
        int dp[][] = new int[totalDisk + 1][totalMemory + 1];
        for (int i = 0; i <= totalDisk; i++) {
            for (int j = 0; j <= totalMemory; j++) {
                dp[i][j] = 0;
            }
        }
        for (int idx = 0; idx < services.size(); idx++) {
            int disk = services.get(idx).getDisk();
            for (int i = totalDisk; i >= disk; i--) {
                int memory = services.get(idx).getMemory();
                int users = services.get(idx).getusers();
                for (int j = totalMemory; j >= memory; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - disk][j - memory] + users);
                }
            }
        }
        
        return dp[totalDisk][totalMemory];
    }

    private static List<Service> parseServices(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new ArrayList<Service>(0);
        }
        List<Service> services = new ArrayList<>(strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            String[] serviceArr = strArr[i].split(",");
            int disk = Integer.parseInt(serviceArr[0]);
            int memory = Integer.parseInt(serviceArr[1]);
            int users = Integer.parseInt(serviceArr[2]);
            services.add(new Service(disk, memory, users));
        }
        return services;
    }

    static class Service {
        private int disk;

        private int memory;

        private int users;

        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getusers() {
            return users;
        }

        public void setusers(int users) {
            this.users = users;
        }
    }
}
