# java-concurrency-lab
# Java Concurrency Lab - Day1

## 生产者-消费者模型实现
### 运行方式
```bash
javac src/main/java/com/demo/day1/*.java
java -cp src/main/java com.demo.day1.ProducerConsumerDemo

##锁优化策略
1.分离生产/消费等待条件
2.使用ReentrantLock非公平模式
3.严格遵循lock-unlock范式
4.支持多生产者和多消费者

##分析synchronized与ReentrantLock区别

synchronized:
锁获取方式：JVM隐式管理
可中断性：不可中断
公平性：非公平性
条件变量：单个监视器
性能：JDK6后优化后相当
锁绑定：与对象头关联

ReentrantLock:
锁获取方式：显式lock()/unlock()
可中断性：支持lockInterruptibly()
公平性：可配置公共锁
条件变量：支持多个Condition
性能：高竞争场景更优
锁绑定：独立锁对象

#核心区别说明：
1.锁的实现机制
--synchronized基于JVM管程（Monitor）实现
--ReentrantLock基于AQS（AbstractQueueSynchronizer）实现
2.使用场景选择

# 优先使用synchronized的场景：
// - 简单同步需求
// - 需要自动释放锁

// 应选择ReentrantLock的场景：
// - 需要公平锁
// - 需要尝试获取锁（tryLock）
// - 需要分离读写操作（ReadWriteLock）
// - 需要分组唤醒线程（多个Condition）
