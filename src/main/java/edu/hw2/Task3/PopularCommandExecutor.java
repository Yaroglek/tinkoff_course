package edu.hw2.Task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    private Exception cause;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public Exception getCause() {
        return cause;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        int attempts = 0;
        Connection connection = manager.getConnection();
        while (attempts < maxAttempts) {
            attempts++;
            try (connection) {
                connection.execute(command);
                return;
            } catch (Exception ignored) {

            }
        }
        cause = new ConnectionException(2, "all attempts are used");
        throw cause;
    }
}
