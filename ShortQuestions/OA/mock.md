## Error & Exception

- Error
  - 表示严重的问题，程序无法处理或者无法恢复的情况。
  - 与 JVM 有关的错误，通常由于系统级故障或虚拟机运行时的严重问题而引起，例如内存溢出（OutOfMemoryError）或虚拟机崩溃（VirtualMachineError）等。
  - 程序通常无法或不应该捕获或处理 Error，因为它们表示了一些不可恢复的情况，程序无法继续正常运行。
  - OutOfMemoryError 内存溢出
  - StackOverFlowError CPU
- Checked(Compile) Exception:
  - 由于外部环境或资源问题引起的，因此被归类为受检查异常。受检查异常需要在代码中显式处理
  - exceptions that are checked at compile time.
  - E.g. IOException, SQLException
- Unchecked(Runtime) Exception:
  - exceptions that are checked at runtime.
  - E.g. NullPointerException

## Lambda Expression
