package me.mwon.discordminecraftlinker.mixin;

import me.mwon.discordminecraftlinker.DiscordMinecraftLinker;
import net.minecraft.server.filter.TextStream.Message;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class InterceptNetworkMessages {
    @Shadow public ServerPlayerEntity player;
    @Inject(at = @At("HEAD"), method = "handleMessage(Lnet/minecraft/server/filter/TextStream$Message;)V")
        private void logMessage(Message message, CallbackInfo info) {
            String messageString = message.getRaw();
            DiscordMinecraftLinker.LOGGER.info("Received a message from " + player.getEntityName() + " : \"" + messageString + "\"");
        }
}
