package com.sophswrath.mixin;

import com.sophswrath.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class ModEntityDataSaverMixin implements IEntityDataSaver {

	@Shadow @Final private EntityType<?> type;
	private NbtCompound persistentData;

	@Override
	public NbtCompound getPersistentData() {
		if (this.persistentData == null) {
			this.persistentData = new NbtCompound();
		}
		return persistentData;
	}

	@Inject(method = "writeNbt", at = @At("HEAD"))
	protected void writeCustomNbt(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
		if (persistentData != null) {
			nbt.put("sophs-wrath.data", persistentData);
		}
	}

	@Inject(method = "readNbt", at = @At("HEAD"))
	protected void readCustomNbt(NbtCompound nbt, CallbackInfo ci) {
		if (nbt.contains("sophs-wrath.data", 10)) {
			persistentData = nbt.getCompound("sophs-wrath.data");
		}
	}

}