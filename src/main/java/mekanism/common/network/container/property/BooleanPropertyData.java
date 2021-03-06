package mekanism.common.network.container.property;

import mekanism.common.inventory.container.MekanismContainer;
import mekanism.common.network.container.PacketUpdateContainerBoolean;
import net.minecraft.network.PacketBuffer;

public class BooleanPropertyData extends PropertyData {

    private final boolean value;

    public BooleanPropertyData(short property, boolean value) {
        super(PropertyType.BOOLEAN, property);
        this.value = value;
    }

    @Override
    public PacketUpdateContainerBoolean getSinglePacket(short windowId) {
        return new PacketUpdateContainerBoolean(windowId, getProperty(), value);
    }

    @Override
    public void handleWindowProperty(MekanismContainer container) {
        container.handleWindowProperty(getProperty(), value);
    }

    @Override
    public void writeToPacket(PacketBuffer buffer) {
        super.writeToPacket(buffer);
        buffer.writeBoolean(value);
    }
}