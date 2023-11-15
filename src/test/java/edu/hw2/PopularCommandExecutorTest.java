package edu.hw2;

import edu.hw2.Task3.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PopularCommandExecutorTest {

    @Test
    void updatePackages() {
        var executor = new PopularCommandExecutor(new ConnectionManager.DefaultConnectionManager(), 0);
        ConnectionException exception = assertThrows(ConnectionException.class, executor::updatePackages);
        assertEquals("Exception: all attempts are used. Code: 2", exception.getMessage());
    }
}
