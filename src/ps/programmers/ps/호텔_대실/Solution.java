package ps.programmers.ps.호텔_대실;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    static int answer = 0;

    public int solution(String[][] book_time) {
        List<Room> rooms = new ArrayList<>();
        PriorityQueue<Room> reservedRooms = new PriorityQueue<>(Comparator.comparingInt(room -> room.end));

        for (String[] strings : book_time) {
            String startTime = strings[0];
            String endTime = strings[1];
            Room newRoom = new Room(startTime, endTime);
            rooms.add(newRoom);
        }

        rooms.sort(Comparator.comparingInt(o -> o.start));

        for (Room eachRoom : rooms) {
            if (!reservedRooms.isEmpty() && eachRoom.start >= reservedRooms.peek().end) {
                reservedRooms.poll();
            } else {
                answer++;
            }
            reservedRooms.add(eachRoom);
        }
        return answer;
    }

    static int index = 0;

    static class Room implements Comparable<Room> {
        private static final int CLEAN_TIME = 10;
        int roomNumber;
        int start;
        int end;

        public Room(String startTime, String endTime) {
            this.roomNumber = index++;
            this.start = calculateMinute(startTime);
            this.end = calculateMinute(endTime) + CLEAN_TIME;
        }

        private int calculateMinute(String time) {
            String[] timeArray = time.split(":");
            int hour = Integer.parseInt(timeArray[0]);
            int minute = Integer.parseInt(timeArray[1]);
            return hour * 60 + minute;
        }

        @Override
        public int compareTo(Room o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return String.format("[Numbber: %s, Start: %s, End: %s]", roomNumber, start, end);
        }
    }

    public static void main(String[] args) throws Exception {
        String[][] rooms = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        String[][] rooms2 = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        Solution solution = new Solution();
        System.out.println(solution.solution(rooms));
    }
}
