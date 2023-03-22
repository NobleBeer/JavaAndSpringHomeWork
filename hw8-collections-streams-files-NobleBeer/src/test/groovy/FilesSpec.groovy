import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class FilesSpec extends Specification{
    def "9. read int should return correct"() {
        given:
        def bufferOut = new ByteArrayOutputStream()
        System.out = new PrintStream(bufferOut)
        def testIn = new ByteArrayInputStream(enteringNumber.toString().getBytes())
        System.setIn(testIn)


        def conditions = new PollingConditions(
                timeout: 3, initialDelay: 0, factor: 1.25
        )
        def msg = message

        Runnable taskRunnableObject = new Runnable() {
            int value;

            @Override
            void run() {
                value = FilesTasks.readInt(msg)
            }

        }
        def fileTaskThread = new Thread(taskRunnableObject)

        when:
        fileTaskThread.start()

        then:
        conditions.eventually {
            assert bufferOut.toString().trim() == message
        }

        when:
        fileTaskThread.join()

        then:
        taskRunnableObject.getValue() == enteringNumber

        where:
        message        ||   enteringNumber
        "Enter number" ||   5
        "Enter phone"  ||   90526683
        "Enter age"    ||   24
    }

    def "10 read int should return correct"() {
        when:
        FilesTasks.renameFiles(sourceList as List<String>)

        then:
        sourceList == expectedList

        where:
        sourceList                                        ||     expectedList
        ["aboba.txt", "babich.doc", "meme1488.jpeg"]      ||     ["1_aboba.txt", "2_babich.doc", "3_meme1488.jpeg"]
        []                                                ||     []
    }
}
