package com.politecnico.servicebookings.client;

import com.politecnico.servicebookings.models.Showtimes;
import com.politecnico.servicebookings.models.Users;
import com.politecnico.servicebookings.utils.Response;
import com.politecnico.servicebookings.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserClientFallBackHystrix implements UserClient{

    private final ResponseBuilder builder;

    @Override
    public Response findById(Long id) {
        Users user = new Users();
                user.setId(1L);
                user.setName("mundo");
                user.setLastName("pues");
        return  builder.success(user);
    }

}