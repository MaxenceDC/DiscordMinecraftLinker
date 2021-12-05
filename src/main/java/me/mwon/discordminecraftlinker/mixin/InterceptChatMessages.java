package me.mwon.discordminecraftlinker.mixin;

import me.mwon.discordminecraftlinker.DiscordMinecraftLinker;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatHud.class)
public class InterceptChatMessages {
    @Inject(at = @At("HEAD"), method = "addMessage(Lnet/minecraft/text/Text;)V")
        private void addMessage(Text message, CallbackInfo info) {
            DiscordMinecraftLinker.LOGGER.info("Message received : " + message.getString());
        }
}