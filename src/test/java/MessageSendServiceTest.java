import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.task.DoorayMessageSender;
import com.nhnacademy.task.MessageSendService;
import com.nhnacademy.task.MessageSender;
import com.nhnacademy.task.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MessageSendServiceTest {
    @Test
    void testDoorayMessageSender() {
        DoorayHookSender doorayHookSender = mock(DoorayHookSender.class);
        doNothing().when(doorayHookSender).send(any(DoorayHook.class));

        DoorayMessageSender doorayMessageSender= new DoorayMessageSender(doorayHookSender);
        User user = new User("email","1234");
        boolean actual = doorayMessageSender.sendMessage(user,"message");
        Assertions.assertThat(actual).isEqualTo(true);




    }
}
