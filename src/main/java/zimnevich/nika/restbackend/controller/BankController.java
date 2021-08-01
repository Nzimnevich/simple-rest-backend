package zimnevich.nika.restbackend.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zimnevich.nika.restbackend.domain.LoginInfo;
import zimnevich.nika.restbackend.domain.UserInfo;
import zimnevich.nika.restbackend.exception.InvalidUserNameException;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {
    private Map<String, UserInfo> users = Map.of(
            "Nika", UserInfo.builder().userName("Nika").build(),
            "Nyasha", UserInfo.builder().userName("Nyasha").build(),
            "Nikita", UserInfo.builder().userName("Nikita").build()
    );

    @PostMapping("user/login")
    @ApiOperation("авторизация")
    //@ApiImplicitParam описание параметров
    public UserInfo doLogin(@RequestBody LoginInfo loginInfo) {
        if (loginInfo.getUserName().equals("Nika")) {
            return UserInfo.builder()
                    .loginData(new Date())
                    .userName(loginInfo.getUserName())
                    .build();
        } else {
            throw new InvalidUserNameException();
        }

    }


    @GetMapping("user/getAll")
    @ApiOperation("Получение всех пользователей")
    public List<UserInfo> getAllUserInfo() {
        return users.values().stream().collect(Collectors.toList());
    }
}
