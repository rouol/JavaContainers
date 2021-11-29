package com.mephi.rouol;

import com.mephi.rouol.AccountantBot.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // old labs
        /*
        // checking the List
        System.out.println("\n        checking the List\n");
        {
            List list = new List();

            System.out.println(list.isEmpty());

            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.remove(2);
            System.out.println(list.get(2));

            System.out.println(list.get(0));

            System.out.println(list.contains(8));
            list.add(8, 1);
            System.out.println(list.contains(8));
            System.out.println(list.indexOf(8));

            System.out.println(list.size());

            System.out.println(list.isEmpty());

            System.out.println(list);
            System.out.println(list.remove(1));
            System.out.println(list);

            list.add(10, 4);
            System.out.println(list);

            System.out.println(list.set(100, 4));
            System.out.println(list);

            List newlist = new List(10, "sdjfhjshdfkjsh");
            System.out.println(newlist);
        }

        // checking the Map
        {
            System.out.println("\n        checking the Map\n");

            Map map = new Map();

            System.out.println(map.isEmpty());

            map.put(0, 10);
            map.put(1, "ааа");
            map.put(17, new List(3, "ыыы"));
            map.put(2, 228);
            map.put(3, "java");
            map.put("dsjfkl", "sdfsdfsdf");
            System.out.println(map);
            System.out.println(map.get("dsjfkl"));
            System.out.println(map.remove(1));
            System.out.println(map.keyContains(100));
            System.out.println(map.get(100, "100"));
            System.out.println(map.keyContains(100));
            System.out.println(map);
            System.out.println(map.getKeys().toString());
            System.out.println(map.getValues().toString());
            System.out.println(map.getEntries().toString());
            System.out.println(map.size());

            System.out.println(map.isEmpty());
        }

        // checking mergeSortedLists
        {
            List a = new List(new Object[]{0, 1, 2, 7, 9});
            List b = new List(new Object[]{-1, 2, 3, 4, 5, 8, 11});
            List merged = List.mergeSortedLists(a, b);
            System.out.println(merged);
        }

        System.out.println();
        System.out.println("\n                          LAB 2\n");
        System.out.println("\n        checking countAllSubstr and reduceOccurences\n");
        // checking countAllSubstr
        {
            String str = "aaa bab jsd sdfs jsd aaa aaa aba";
            System.out.println(str);
            System.out.println(StringEditor.countAllSubstr(str));
            System.out.println(StringEditor.reduceOccurences(str));
        }
        */

//        System.out.println("\n/** LAB 3 **/");
//        {
//            ArrayList<Employee> employees = Employee.createShortList();
//            //System.out.println(employees);
//            System.out.println(Accountant.paySalary(employees.get(11)));
//            System.out.println(Accountant.payPremium(employees.get(9)));
//            System.out.println("\n/** Выплата премии женщинам сотрудникам **/");
//            AccountantDemo.payPremiumToWomen(employees);
//            System.out.println("\n/** Выплата зарплаты сотрудникам определенного департамента **/");
//            AccountantDemo.paySalaryByDept(employees, Employee.Dept.IT);
//            System.out.println("\n/** Выплата премии сотрудникам старше 30, работающим в определенном департаменте **/");
//            AccountantDemo.payPremiumByDept30Plus(employees, Employee.Dept.SALES);
//            System.out.println("\n/** Выплата зарплаты менеджерам **/");
//            AccountantDemo.paySalaryToManagers(employees);
//            System.out.println("\n/** Выплата премии стаффу **/");
//            AccountantDemo.payPremiumToStaff(employees);
//
//            System.out.println("\n/** HW for LAB 3 **/\n");
//            System.out.println("/** Consumer Lambda Expression **/");
//            FunctionalInterfacesDemo.exampleConsumerLambdaExpression(employees);
//            System.out.println("/** Function Lambda Expression **/");
//            FunctionalInterfacesDemo.exampleFunctionLambdaExpression(employees);
//            System.out.println("/** Supplier Lambda Expression **/");
//            FunctionalInterfacesDemo.exampleSupplierLambdaExpression();
//            System.out.println("\n/** BiPredicate Lambda Expression **/");
//            FunctionalInterfacesDemo.exampleBiPredicateLambdaExpression(employees);
//        }

        System.out.println("\n/** LAB 4 **/");
        {
            ArrayList<Employee> employees = Employee.createShortList();
            System.out.println("/** map **/");
            StreamDemo.paySalaryToITDept(employees);
            System.out.println("/** map and peek **/");
            StreamDemo.paySalaryToITDeptANDPrint(employees);
            System.out.println("/** findFirst **/");
            StreamDemo.showFirstFromITDept(employees);
            System.out.println("/** lazy **/");
            StreamDemo.payPremiumToITDept(employees);

            employees = Employee.createShortList();
            employees.stream().map(Accountant::paySalary).forEach(System.out::print);
            employees.stream().map(Accountant::payPremium).forEach(System.out::print);;

            System.out.println("/** max **/");
            StreamDemo.employeeWithMaxSalary(employees);
            System.out.println("/** min **/");
            StreamDemo.employeeWithMinSalary(employees);
            System.out.println("/** average **/");
            StreamDemo.employeesAvgSalary(employees);
            System.out.println("/** sum **/");
            StreamDemo.employeesSumSalary(employees);
        }

        System.out.println("\n/** LAB 5 **/");
        {

            Object[] arr = new Object[]{-1, 2, 3, 4, 5, 8, 11};
            try {
                Object a = arr[20];
                } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** FileNotFoundException **/");
            try {
                File file = new File("nonexistent.txt");
                Scanner scan = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** NullPointerException **/");
            try {
                String myString = null;
                System.out.println(myString.toLowerCase(Locale.ROOT));
            } catch (NullPointerException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** IOException **/");
            try {
                File file = new File("nonexistent.txt");
                FileInputStream fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** ClassCastException **/");
            try {
                Object i = 42;
                String s = (String)i;
            } catch (ClassCastException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** ArithmeticException **/");
            try {
                int exampleVariableOne = 500/0;
            } catch (ArithmeticException e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** OutOfMemoryError **/");
            try {
                Integer[] myArray = new Integer[1000 * 1000 * 1000 * 10];
            } catch (OutOfMemoryError e) {
                System.out.println("поймано " + e);
            }

            System.out.println("\n/** StackOverflowError **/");
            try {
                StackOverflowErrorExample soee = new StackOverflowErrorExample();
                soee.print(0);
            } catch (StackOverflowError e) {
                System.out.println("поймано " + e);
            }

        }

        System.out.println("\n/** HW 5 **/");
        {
            System.out.println("\nЗадание 1:");
            {
                // Abe Lincoln's Birthday: February 12, 1809, died April 15, 1855
                //   How old when he died?
                //   How many days did he live?
                {
                    LocalDate _AbeLincolnBirthday = LocalDate.of(1809, 2, 12);
                    LocalDate _AbeLincolnDeath = LocalDate.of(1855, 4, 15);
                    System.out.println();
                    System.out.println("Abe Lincoln's Birthday: February 12, 1809, died April 15, 1855");
                    System.out.println("How old when he died? " + ChronoUnit.YEARS.between(_AbeLincolnBirthday, _AbeLincolnDeath));
                    System.out.println("How many days did he live? " + ChronoUnit.DAYS.between(_AbeLincolnBirthday, _AbeLincolnDeath));
                }

                // Bennedict Cumberbatch, July 19, 1976
                //   Born in a leap year?
                //   How many days in the year he was born?
                //   How many decades old is he?
                //   What was the day of the week on his 21st birthday?
                {
                    LocalDate _BennedictCumberbatchBirthday = LocalDate.of(1976, 7, 19);
                    System.out.println();
                    System.out.println("Bennedict Cumberbatch, July 19, 1976");
                    System.out.println("Born in a leap year? " + (_BennedictCumberbatchBirthday.isLeapYear() ? "Yes" : "No"));
                    System.out.println("How many days in the year he was born? " + _BennedictCumberbatchBirthday.lengthOfYear());
                    System.out.println("How many decades old is he? " + ChronoUnit.DECADES.between(_BennedictCumberbatchBirthday, LocalDate.now()));
                    System.out.println("What was the day of the week on his 21st birthday? " + _BennedictCumberbatchBirthday.plus(21, ChronoUnit.YEARS).getDayOfWeek());
                }

                // Train departs Boston at 1:45PM and arrives New York 7:25PM
                //   How many minutes long is the train ride?
                //   If the train was delayed 1 hour 19 minutes, what is the actual arrival time?
                {
                    LocalTime _TrainDepartsBoston = LocalTime.of(1 + 12, 45, 0);
                    LocalTime _TrainArrivesNewYork = LocalTime.of(7 + 12, 25, 0);
                    LocalTime _TrainArrivesNewYorkLate = _TrainArrivesNewYork.plusHours(1).plusMinutes(19);
                    System.out.println();
                    System.out.println("Train departs Boston at 1:45PM and arrives New York 7:25PM");
                    System.out.println("How many minutes long is the train ride? " + ChronoUnit.MINUTES.between(_TrainDepartsBoston, _TrainArrivesNewYork));
                    System.out.println("If the train was delayed 1 hour 19 minutes, what is the actual arrival time? " + _TrainArrivesNewYorkLate);
                }


                // Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes
                //   When does it arrive in Miami?
                //   When does it arrive if the flight is delays 4 hours 27 minutes?
                {
                    LocalDateTime _FlightLeaves = LocalDateTime.of(2021, 3, 24, 9 + 12, 15, 0);
                    LocalTime _FlightTime = LocalTime.of(4, 15, 0);
                    LocalTime _FlightDelay = LocalTime.of(4, 27, 0);
                    LocalDateTime _FlightArrives = _FlightLeaves.plusHours(_FlightTime.getHour()).plusMinutes(_FlightTime.getMinute());
                    LocalDateTime _FlightArrivesLate = _FlightArrives.plusHours(_FlightDelay.getHour()).plusMinutes(_FlightDelay.getMinute());
                    System.out.println();
                    System.out.println("Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes");
                    System.out.println("When does it arrive in Miami? " + _FlightArrives);
                    System.out.println("When does it arrive if the flight is delays 4 hours 27 minutes? " + _FlightArrivesLate);
                }


                // School semester starts the second Tuesday of September of this year.
                //   Hint: Look at the TemporalAdjusters class
                //   What is the date?
                //   School summer vacation starts June 25th
                //   Assuming:
                //     *  Two weeks off in December
                //     *  Two other vacation weeks
                //     *  School is taught Monday - Friday
                //   How many days of school are there?
                //   Hint: keep track of the short weeks also
                {
                    LocalDate _1stSeptember = LocalDate.of(LocalDate.now().getYear(), 9, 1);
                    LocalDate _lastDay = LocalDate.of(LocalDate.now().plusYears(1).getYear(), 6, 24);           // friday
                    LocalDate _firstDay = _1stSeptember.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY));   // tuesday

                    long totalDays = ChronoUnit.DAYS.between(_firstDay, _lastDay);
                    totalDays -= 2 * 7; // Two weeks off in December
                    totalDays -= 2 * 7; // Two other vacation weeks
                    long totalWeeks = ChronoUnit.WEEKS.between(_firstDay, _lastDay);
                    totalDays -= 2 * (totalWeeks - 4); // weekends minus ones in vacation weeks
                    totalDays -= 1; // 4th Nov
                    totalDays -= 1; // 23rd Feb
                    totalDays -= 1; // 8th Mar
                    totalDays -= 2; // 2-3 May
                    totalDays -= 2; // 9-10 May
                    totalDays -= 1; // 13 Jun

                    System.out.println();
                    System.out.println("School semester starts the second Tuesday of September of this year.\n" +
                            "Hint: Look at the TemporalAdjusters class\n" +
                            "What is the date?\n" +
                            "School summer vacation starts June 25th\n" +
                            "Assuming:\n" +
                            "  *  Two weeks off in December\n" +
                            "  *  Two other vacation weeks\n" +
                            "  *  School is taught Monday - Friday\n" +
                            "Hint: keep track of the short weeks also");
                    System.out.println("How many days of school are there? " + totalDays);
                }


                // A meeting is schedule for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.
                //   What is the time of the week's meetings?
                {
                    LocalDateTime _today = LocalDateTime.now();
                    LocalDateTime _meetingDay = (_today.getDayOfWeek().equals(DayOfWeek.TUESDAY)) ? _today : _today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));

                    LocalTime _meetingTime = LocalTime.of(1 + 12, 30, 0);
                    System.out.println();
                    System.out.println("A meeting is schedule for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.");
                    System.out.println("What is the time of the week's meetings? " + ((_today.getDayOfWeek().equals(DayOfWeek.TUESDAY)) ? _meetingTime : "No meetings"));
                }
            }
            System.out.println("\nЗадание 2:");
            {
                // Using the following information:
                //   * Use America/New_York as the time zone for Boston Logan Airport(BOS).
                //   * Use America/Los_Angeles as the time zone for San Francisco Airport (SFO).
                //   * Use Asia/Calcutta as the time zone for Bangalore's Bengaluru International Airport (BLR)
                ZoneId AmericaNewYork = ZoneId.of("America/New_York");
                ZoneId AmericaLosAngeles = ZoneId.of("America/Los_Angeles");
                ZoneId AsiaCalcutta = ZoneId.of("Asia/Calcutta");

                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss Z");


                // Flight 123, San Francisco to  Boston, leaves SFO at 10:30 PM June 13, 2014
                // The flight is 5 hours 30 minutes
                //   What is the local time in Boston when the flight takes off?
                //   What is the local time at Boston Logan airport when the flight arrives?
                //   What is the local time in San Francisco when the flight arrives?
                {
                    System.out.println();
                    System.out.println(
                            "Flight 123, San Francisco to  Boston, leaves SFO at 10:30 PM June 13, 2014\n" +
                                    "                The flight is 5 hours 30 minutes");
                    LocalDateTime flightDeparture = LocalDateTime.of(2014, 6, 13, 10+12, 30, 0);
                    ZonedDateTime flightDepartureSFO = ZonedDateTime.of(flightDeparture, AmericaLosAngeles);
                    ZonedDateTime flightDepartureBoston = flightDepartureSFO.toInstant().atZone(AmericaNewYork);
                    System.out.println("What is the local time in Boston when the flight takes off? " + flightDepartureBoston.format(timeFormatter));
                    ZonedDateTime flightArrivalSFO = flightDepartureSFO.plusHours(5).plusMinutes(30);
                    ZonedDateTime flightArrivalBoston = flightDepartureBoston.plusHours(5).plusMinutes(30);
                    System.out.println("What is the local time in Boston when the flight takes off? " + flightArrivalBoston.format(timeFormatter));
                    System.out.println("What is the local time in San Francisco when the flight arrives? " + flightArrivalSFO.format(timeFormatter));
                }

                // Flight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014
                // The flight time is 22 hours
                //   Will the traveler make a meeting in Bangalore Monday at 9 AM local time?
                //   Can the traveler call her husband at a reasonable time when she arrives?
                {
                    System.out.println();
                    System.out.println(
                            "Flight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014\n" +
                                    "                The flight time is 22 hours");
                    LocalDateTime flightDeparture = LocalDateTime.of(2014, 6, 28, 10+12, 30, 0);
                    ZonedDateTime flightDepartureSFO = ZonedDateTime.of(flightDeparture, AmericaLosAngeles);
                    ZonedDateTime flightDepartureBangalore = flightDepartureSFO.toInstant().atZone(AsiaCalcutta);
                    ZonedDateTime flightArrivalSFO = flightDepartureSFO.plusHours(22);
                    ZonedDateTime flightArrivalBangalore = flightDepartureBangalore.plusHours(22);
                    System.out.println("Will the traveler make a meeting in Bangalore Monday at 9 AM local time? " +
                            ( ( (flightArrivalBangalore.getDayOfWeek().getValue() <= DayOfWeek.MONDAY.getValue()) && (flightArrivalBangalore.getHour() < 9) ) ? "Yes" : "No") );
                    System.out.println("Can the traveler call her husband at a reasonable time when she arrives? " +
                            ((7 < flightArrivalSFO.getHour()) && (flightArrivalSFO.getHour() < 23) ? "Yes" : "No"));
                }


                // Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014
                // Flight time is 5 hours 30 minutes.
                //   What day and time does the flight arrive in Boston?
                //   What happened?
                {
                    System.out.println();
                    System.out.println(
                            "Flight 123, San Francisco to  Boston, leaves SFO at 10:30 PM June 13, 2014\n" +
                                    "                The flight is 5 hours 30 minutes");
                    LocalDateTime flightDeparture = LocalDateTime.of(2014, 11, 1, 10+12, 30, 0);
                    ZonedDateTime flightDepartureSFO = ZonedDateTime.of(flightDeparture, AmericaLosAngeles);
                    ZonedDateTime flightDepartureBoston = flightDepartureSFO.toInstant().atZone(AmericaNewYork);
                    ZonedDateTime flightArrivalSFO = flightDepartureSFO.plusHours(5).plusMinutes(30);
                    ZonedDateTime flightArrivalBoston = flightDepartureBoston.plusHours(5).plusMinutes(30);
                    System.out.println("What day and time does the flight arrive in Boston? " + flightArrivalBoston.format(dateTimeFormatter));
                    System.out.println("What happened? " + "Timezone changed from Summer Time to Winter Time");
                    System.out.println("had been " + flightArrivalBoston.format(dateTimeFormatter));
                    System.out.println("was " + flightDepartureBoston.format(dateTimeFormatter));
                }
            }

        }

    }
}
