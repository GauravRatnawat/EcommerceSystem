package orderManagement.Infrastructure.Publisher;

import org.springframework.stereotype.Service;

import orderManagement.Application.Interfaces.IPublisher;

@Service
class Publisher implements IPublisher
{
    public void Publish(Object o)
    {
       //Perform publishing logic via a message bus
    }
}

