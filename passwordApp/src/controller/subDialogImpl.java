package controller;

import java.io.IOException;

import com.zxr.domain.User;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * @author zxr:zhaoxinran_dlmuit@163.com
 * @version 创建时间：2017年12月24日 上午1:04:16 类说明 AltretDialog 各类弹窗的controller方法
 */
public class subDialogImpl implements SubDialog {
	// 主窗口对象生成

	@FXML
	private Button OKButton;
	@FXML
	private Button add_submit;
	

	@FXML
	public void OKButton(ActionEvent event) {
	}

	@Override
	public void add_RegisDialog(Stage primaryPage) {		
		//监听信息录入情况
		User user = new User();
		BooleanProperty accessGranted = new SimpleBooleanProperty(false);
		//加载Add_RegisDialog.fxml文件
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/add_RegisDialog.fxml"));
		System.out.println(getClass().getResource("/view/add_RegisDialog.fxml"));
		try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//======显示窗口====
		// 获取根节点
		Parent root = loader.getRoot();
		// 初始化窗口
		Stage add_RegisDialog = new Stage(StageStyle.DECORATED);
		// 定义一个模式窗口，阻止事件传递到其整个所有者窗口层次结构
		add_RegisDialog.initModality(Modality.WINDOW_MODAL);
		// 实现模态 将子节点与父节点连接
		add_RegisDialog.initOwner(primaryPage);
		// 指定要在此阶段使用的场景。
		add_RegisDialog.setTitle("信息录入");
		Scene scene = new Scene(root);
		add_RegisDialog.setScene(scene);
		//尝试通过将可见性设置为true来显示此窗口
		add_RegisDialog.show();
		
		//controller控件实现
		this.add_submit = (Button) root.lookup("#add_submit");
		add_submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//用javafx Bean 获取界面输入
				 PasswordField passwordField = new PasswordField();
				 user.
				 passwordField.setOnAction(ActionEvent->{
					if(accessGranted.get()){
						System.out.println("password:"+);
					}
				 });
				//记录存入信息是否成功
				add_ConfmDialog(add_RegisDialog);
			}
		});
		
	}

	@Override
	public void add_ConfmDialog(Stage primaryPage) {

		// 加载AlertDialog.fxml文件
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/add_ConfmDialog.fxml"));
		try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取根节点
		Parent root = loader.getRoot();
		// 初始化窗口
		Stage add_ConfmDialog = new Stage(StageStyle.DECORATED);
		// 定义阻止事件传递到其他应用程序窗口的模式窗口。要实现这个操作但是
		add_ConfmDialog.initModality(Modality.APPLICATION_MODAL);
		// 实现模态 将子节点与父节点连接
		add_ConfmDialog.initOwner(primaryPage);
		// 指定要在此阶段使用的场景。
		add_ConfmDialog.setTitle("提示");
		Scene scene = new Scene(root);
		add_ConfmDialog.setScene(scene);
		// 尝试通过将可见性设置为true来显示此窗口
		add_ConfmDialog.show();

		// controller控件函数
		this.OKButton = (Button) root.lookup("#OKButton");
		OKButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// subAddButton获得Scence对象，Window对象
				add_ConfmDialog.getScene().getWindow().hide();
			}
		});

	}

	@Override
	public void del_RegisDialog(Stage primaryPage) {

	}

	@Override
	public void del_ConfmDialog(Stage primaryPage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void que_RegisDialog(Stage primaryPage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void que_ConfmDialog(Stage primaryPage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void upd_RegisDialog(Stage primaryPage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void upd_ConfmDialog(Stage primaryPage) {
		// TODO Auto-generated method stub

	}

	@FXML public void add_password(ActionEvent event) {}

	@FXML public void add_website(ActionEvent event) {}

	@FXML public void add_urls(ActionEvent event) {}

	@FXML public void add_userName(ActionEvent event) {}

	@FXML public void add_email(ActionEvent event) {}

	@FXML public void add_tel(ActionEvent event) {}

	@FXML public void add_timeStamp(ActionEvent event) {}

	@FXML public void add_submit(ActionEvent event) {}

}