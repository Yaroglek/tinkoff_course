package edu.hw2.Task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    private ConnectionException cause;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        int attempts = 0;
        Connection connection = manager.getConnection();
        while (attempts < maxAttempts) {
            attempts++;
            cause = null;
            try (connection) {
                connection.execute(command);
                return;
            } catch (ConnectionException exception) {
                cause = exception;
            }
        }
        throw new ConnectionException(2, "all attempts are used");
    }
}
