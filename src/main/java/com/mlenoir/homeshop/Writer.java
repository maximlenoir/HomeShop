package com.mlenoir.homeshop;

public interface Writer {
    /**
     * Start writing process.
     */
    public void start();

    /**
     * Write on line.
     *
     * @param line The line to write.
     */
    public void writeLine(String line);

    /**
     * Stop writing process.
     */
    public void stop();
}
