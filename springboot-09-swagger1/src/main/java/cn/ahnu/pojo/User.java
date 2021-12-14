package cn.ahnu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@ApiModel("User：用户实体类")
public class User {
    public int id;
    @ApiModelProperty("用户名")
    public String username;
    @ApiModelProperty("密码")
    public String password;

}
