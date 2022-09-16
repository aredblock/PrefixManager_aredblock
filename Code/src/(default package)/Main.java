
/**
 * Copyright (c) 2022 aredblock
 */
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author aredblock
 */
public class Main extends JavaPlugin {
	private ChatColor Code;

	@Override
	public void onEnable() {

	}

	public boolean onCommand(CommandSender sender, Command befehl, String befehlsname, String[] args) {

		if (sender instanceof Player) {

			// manage command
			if (befehlsname.equalsIgnoreCase("mp")) {
				Player p = (Player) sender;
				if (p.isOp()) {
					if (args[0].equalsIgnoreCase("add")) {
						try {

							codeLib(args[3]);

							var prefix = Code.toString() + args[2] + ChatColor.DARK_GRAY + " | "
									+ ChatColor.WHITE.toString() + args[1];
							p.sendMessage(prefix);
							p.setDisplayName(prefix);
							p.setCustomName(prefix);
							p.setPlayerListName(prefix);
							p.sendMessage(ChatColor.GREEN.toString() + "Prefix is created!");
						} catch (Exception e) {
							p.sendMessage(ChatColor.RED.toString() + "Error entering command. For help do /phelp!");
						}
					} else if (args[0].equalsIgnoreCase("remove")) {
						try {
							p.setCustomName(args[1]);
							p.setPlayerListName(args[1]);
							p.setDisplayName(args[1]);
							p.sendMessage(ChatColor.GREEN.toString() + "Prefix is removed!");
						} catch (Exception e) {
							p.sendMessage(ChatColor.RED.toString() + "Error entering command. For help do /phelp!");
						}

					}

				} else {
					p.sendMessage(ChatColor.DARK_RED.toString() + "You are not allowed to do that!");
				}
			}

			// help command
			if (befehlsname.equalsIgnoreCase("phelp")) {
				Player p = (Player) sender;
				p.sendMessage(
						"Change prefixes: /mp <add/remove> <playername> (only for add: <prefix> <A ColorCode: Red ,Blue ,Green ,Aqua ,Black ,Gray>)");
			}
		}

		return true;
	}

	public void codeLib(String arg) {
		if (arg.equalsIgnoreCase("red")) {
			Code = ChatColor.RED;
		}
		if (arg.equalsIgnoreCase("blue")) {
			Code = ChatColor.BLUE;
		}
		if (arg.equalsIgnoreCase("green")) {
			Code = ChatColor.GREEN;
		}
		if (arg.equalsIgnoreCase("aqua")) {
			Code = ChatColor.AQUA;
		}
		if (arg.equalsIgnoreCase("black")) {
			Code = ChatColor.BLACK;
		}
		if (arg.equalsIgnoreCase("gray")) {
			Code = ChatColor.GRAY;
		}
	}
}
