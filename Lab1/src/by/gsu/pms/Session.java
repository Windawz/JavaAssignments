package by.gsu.pms;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

public class Session implements AutoCloseable {
    /**
     * @param managers
     *     may contain nulls.
     */
    public Session(List<Manager> managers) {
        _managers = managers.stream()
            .filter(Objects::nonNull)
            .toList();
    }
    
    private final List<Manager> _managers;
    private boolean _closed = false;
    
    public void run() {
        throwIfClosed();
        if (_managers.isEmpty()) {
            System.out.println("No managers provided.");
        }
        printCompetentManagerCount();
        printAverageAgeOfManagers();
        printManagers();
        printSortedManagers();
        printManagers();
    }
    
    @Override
    public void close() throws Exception {
        if (!_closed) {
            _closed = true;
        }
    }
    
    private void printManagers() {
        System.out.println("Managers:");
        _managers.forEach(Session::printManager);
    }
    
    private void printSortedManagers() {
        System.out.println("Sorted managers:");
        _managers.stream()
            .sorted(Session::compareManagers)
            .forEach(Session::printManager);
    }
    
    private void printAverageAgeOfManagers() {
        System.out.println("Average age:");
        System.out.println(
            _managers.stream()
                .map(Manager::getAge)
                .reduce(0, Integer::sum)
                / _managers.size());
    }
    
    private void printCompetentManagerCount() {
        System.out.println("Competent manager count:");
        System.out.println(
            _managers.stream()
                .filter(Manager::isCompetent)
                .count());
    }
    
    private void throwIfClosed() {
        if (_closed) {
            throw new IllegalStateException("Session has been closed");
        }
    }
    
    private static void printManager(Manager manager) {
        System.out.println(
            MessageFormat.format(
                "Manager {0} is {1} years old and is {2}",
                manager.getSurname(),
                manager.getAge(),
                manager.isCompetent() ? "competent" : "incompetent"));
    }
    
    private static int compareManagers(Manager left, Manager right) {
        int difference = left.getSurname().compareTo(right.getSurname());
        if (difference == 0) {
            difference = Integer.compare(left.getAge(), right.getAge());
        }
        if (difference == 0) {
            difference = Boolean.compare(
                left.isCompetent(),
                right.isCompetent());
        }
        return difference;
    }
}
