package rpgplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import rpgplugin.stat.Stat;

public class Main extends JavaPlugin implements Listener {
	
	public Stat s = new Stat();
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "RPG�÷����� Ȱ��ȭ");
		
	}
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "RPG�÷����� ��Ȱ��ȭ");
	}
	@EventHandler
	public void  PlayerJoin(PlayerJoinEvent event) {
		s.CreateNewStat(event.getPlayer().getUniqueId().toString());
		event.setJoinMessage(ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.WHITE + "�Բ��� �����ϼ̽��ϴ�!");
	}
	
	@EventHandler
	public void Chat(PlayerChatEvent event) {
		Player player = event.getPlayer();
		long[] stat = new long[12];
		stat = s.getStat(player.getUniqueId().toString());
		player.sendMessage("���� ���� : " + stat[0] + "  ���� �� : " + stat[5]);
	}
}
