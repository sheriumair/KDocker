package org.example

import java.io.IOException

fun main(args: Array<String>) {
    if (args.size < 3 || args[0] != "kdock" || args[1] != "run") {
        println("Usage: kdock run <command> <args>")
        return
    }

    val command = args.sliceArray(2 until args.size)

    try {
        val processBuilder = ProcessBuilder(*command)
        processBuilder.inheritIO()

        val process = processBuilder.start()
        val exitCode = process.waitFor()

        System.exit(exitCode)
    } catch (e: IOException) {
        e.printStackTrace()
        System.exit(1)
    } catch (e: InterruptedException) {
        e.printStackTrace()
        System.exit(1)
    }
}
